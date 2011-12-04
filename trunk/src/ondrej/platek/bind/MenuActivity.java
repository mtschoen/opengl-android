package ondrej.platek.bind;


import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.TreeMap;

import ondrej.platek.objLoader.OBJParser;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity {
	private SortedMap<String, Object> objSources = new TreeMap<String, Object>();

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String key = (String) l.getItemAtPosition(position);
		ObjSource source = (ObjSource) objSources.get(key);
		
        Bundle bundle = new Bundle();

        bundle.putSerializable(ObjSource.TITLE, source);

        Intent mIntent = new Intent();
        mIntent.putExtras(bundle);
        setResult(RESULT_OK, mIntent);
        finish();
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		prepareMenu();

		String[] keys = objSources.keySet().toArray(
				new String[objSources.keySet().size()]);

		// TODO update this
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, keys));
	}
	
	public void addMenuItem(String label, String path){
		objSources.put(label, new ObjFromSDcard(path));
	}
	public void addMenuItem(String label, int resID){
		objSources.put(label, new ObjFromResource(resID,this));
	}
	
	void prepareMenu() {		
		addMenuItem(getString(R.string.cube), R.raw.cube);
		addMenuItem(getString(R.string.triangle), R.raw.triangle);
		addMenuItem("Sdcard_cube","/sdcard/opengl-android.obj");
		
		//TODO fill menu
	}
}