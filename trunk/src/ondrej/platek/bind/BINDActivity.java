/*


 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ondrej.platek.bind;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;



public class BINDActivity extends Activity {
    static private String tag = "BINDActivity.java";
    static private final int CHOOSE_MENU = 0;
    BINDView glView;
    private boolean explanation;
    private boolean cameraStatic;
    private String logfile = "/sdcard/opengl-method.log";
    ObjSource defaultSource = new ObjFromResource(R.raw.triangle, this);
    //ObjSource defaultSource = new ObjFromSDcard("/sdcard/opengl-android.obj");
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Bundle extras = intent.getExtras();
        switch(requestCode) {
            case CHOOSE_MENU:
            	ObjSource source = (ObjSource) extras.getSerializable(ObjSource.TITLE);
            	// TODO not working repair
//				mView.UpdateModel(prepareReader(source));
//		mView.UpdateModel(new InputStreamReader(getResources().openRawResource(R.raw.triangle)));
                break;
            default:
            	// TODO for future "intends"
            	break;
        }
    }
    
    private void launchSelectMenu() {
        Intent i = new Intent(this, MenuActivity.class);
        startActivityForResult(i, CHOOSE_MENU);
    }
    
	
	private InputStreamReader prepareReader(ObjSource s) {
		InputStreamReader res;
		try{
			res = s.GetObjReader();
        } catch (FileNotFoundException e) {
			Toast.makeText(this, R.string.obj_not_found, Toast.LENGTH_SHORT);
			try {
				res = defaultSource.GetObjReader();
			} catch (FileNotFoundException e1) {
				Toast.makeText(this,R.string.obj_not_found, Toast.LENGTH_LONG);
				e1.printStackTrace();				
				return null;
			}			
		}
		return res;
	}
    

    @Override protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
//		Debug.startMethodTracing(logfile);
        
        setContentView(R.layout.surface_view_overlay);
//        glView = (BINDView) findViewById(R.id.glview);
        FrameLayout f = (FrameLayout) findViewById(R.id.frame);
        glView = new BINDView(this);
        f.addView(glView);
        
		try { 
	        // Initialize GLSurface with model-Vertexes, normals,.. from default path to file.obj
	        glView.Init(defaultSource.GetObjReader());
		} catch(Exception e){
			Toast.makeText(this,R.string.obj_not_found, Toast.LENGTH_SHORT);
			finish();
		}
        
		// test if the SD card is working
		if(!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
		    Toast.makeText(this, "External SD card not mounted", Toast.LENGTH_LONG).show();
		}
		
        // Check if the system supports OpenGL ES 2.0.
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;
     
        if (supportsEs2) {
            // Request an OpenGL ES 2.0 compatible context.
            // mView.setEGLContextClientVersion(2); // available from Api Level 8
        }
        else {
            // This is where you could create an OpenGL ES 1.x compatible
            // renderer if you wanted to support both ES 1 and ES 2.
        	String msg = "TODO OpenGL ES 1.X is not yet supported";
			Log.e(tag, msg);
        	
        	Toast.makeText(getApplication(), msg, Toast.LENGTH_SHORT);
            return;
        }
    }

    @Override protected void onPause() {
//    	Debug.stopMethodTracing(); 
        super.onPause();
        glView.onPause();
    }

    @Override protected void onResume() {
//		Debug.startMethodTracing(logfile);
        super.onResume();
        glView.onResume();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("motion", event.toString());
        debugDoGLAction();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.help_about:
        	launchHelp("About");
        	return true;
        case R.id.help_nav:
        	launchHelp("Navigation");
        	return true;
        case R.id.explanations_off:
        	setExplanation(false); 
        	return true;
        case R.id.explanations_on:
        	setExplanation(true); 
        	return true;
        case R.id.screensaver:
        	launchScreensaverSettings();
        	return true;
        case R.id.knot_select:
        	launchSelectMenu();        	
        case R.id.cameraStatic:
        	setCameraStatic(true);
        	return true;
        case R.id.cameraDynamic:
        	setCameraStatic(false);
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
	@Override
	protected void onDestroy(){
//		 Debug.stopMethodTracing();
		super.onDestroy();
	}
	
	private void launchScreensaverSettings() {
    	debugDoGLAction();
		// TODO Auto-generated method stub
	}
	
	private void launchHelp(String string) {
    	debugDoGLAction();
		// TODO Auto-generated method stub
		
	}

    public void setExplanation(boolean v) { 
    	this.explanation = v;
    	debugDoGLAction();
    }
    public boolean getExplanation() { return this.explanation; }

    public void setCameraStatic(boolean b) {
    	this.explanation = b;
    	debugDoGLAction();
	}
    public boolean getCameraStatic() { return this.cameraStatic; }
	//  debugging help functions START TODO delete it after usage
    boolean debug_switch = false;
    private void debugDoGLAction() {
      debug_switch = !debug_switch;
      if (debug_switch) {
        this.onPause();
      }
      else {
        this.onResume(); 
      } 
    }
    // debugging help functions END 
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.play, menu);
    	return true;
    }
    

}
