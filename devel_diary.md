# Knots animator development diary #

> Format is month, day in month, year is skipped since I started on **autumn 2011**. In **brackets** is **time spent** on the task and of course the description of the task is at the end.
  * To reduce the size of obj files and the mesh Go in blender to "Object data" icon in right panel
> > and choose as smaller resolution as possible while the model still looks good
  * Models Done 2\*4(h)
  * Shading rewritten for Goroud (6+2+5)
> > TODO 1) some examples still do not work.  2) models 3) VBO
  * 1205 (2.5) Limit rotating and positioning. Set up default rotation and scale. Moved transformation to vertex shader.
  * 1204 (3) Continue from yesterday. Debugging updating Makefile and later debugging opengl positioning and rendering
  * 1203 (6) Separating source code of my application to more files for possible compilation against X11 source code. Identifying JNI specific parts
  * 1202 (4) modifying example from Chapter\_8 of Linux part http://code.google.com/p/opengles-book-samples/ in order to map my application for X11
  * 1215 (2) Added obj files from http://people.sc.fsu.edu/~jburkardt/data/obj/obj.html
  * TODO UPDATA DOCUMENTATION: Which problems I had and how I overcome them. Stress how I transformed XML and OBJ data to load them to OpenGL. Describe the activities graph and so on.
> > Mention the knot app for iphone, compare it to my application
> > http://itunes.apple.com/it/app/knots-3d/id453571750?mt=8

> take some screen shot from development process using
> http://www.addictivetips.com/mobile/how-to-take-screenshots-of-android-device/
> On the other, I could not use sdcard during taking screen shots
  * TODO working on presentation
  * 1207 (3) Modeling 3D knots using Blender
  * 1205 (3) Debugging Editing and populating knots, deleting them, etc..
  * 1205 (2) Editing comments
  * 1204 (5) Database of actual loaded knots
  * 1204 (3) Debuggin FileDialog
  * 1203 (3) Adding FileDialog, Cleaning XML resources
  * 1203 (6) Adding ListActivity for Menu
  * 1202 (2) Loading Obj from resources
  * 1202 (5) Finally solved the bug
  * 1201 (1) Helper functions for LookAt functions
  * 1130 (4) Debugging (awful with Logcat) passing empty 2D array (empty in 2. dim)
  * 1130 (2) Struggle with building Makefile (too much complicated makefile for ndk-build) ->finally simple makefile works
  * 1129 (16) Last days I was restoring deletion of my work:( The main debugging problem was **android-8** target instead of **android-7** target! --UPDATE not true (the main problem was compilation and freeing resources)
  * 1126 (todo) Port the objLoader rendering to native code
  * 1126 (4) Loading normals and faces from OBJ
  * 1126 (0.5) Find the bug in objLoader and understand how the objLoader renders the obj file
  * 1126 (?3) I have learned how to draw OpenGL primitives and adjust vertex shaders.
  * 1124 I got across this site http://androiddevnotes.com/2011/03/08/1299521520000.html which suggest using Android as emulator. Sadly according them OpenGL is not working
  * 1124 We set private static int EGL\_OPENGL\_ES2\_BIT = 4;  but we **get 7**  I hope this means OpenGL ES 2.0
  * 1124 (0.5) Exploring my EGL config
  * 1124 (0.5) Refactoring
  * 1124 (?3) Learning How to set OpenGL ES 2.0 from the book
  * 1123 (?2) Learning How to set OpenGL ES 2.0 from the book
  * 1123 (2) Passing Vertices to OpenGL
  * 1117 (4)  OBJ loader ok. Passing float array of vertexes OK. TODO: pass verteces to OpenGL in good format to see them or change viewpoint
  * 1117 (0.5) To use SD card with debugging is BAD IDEA, use logging instead due to reading OBJ file!
  * 1117 (2) Search how to implement javaOBJ loader since reading resources from Native code can be done only by
> > shared libraries  http://mobilepearls.com/labs/native-android-api/opensles/index.html
  * 1117 (1) Implementing passing arrays and strings through JNI
  * 1117 found http://code.google.com/p/opengles-book-samples/
  * 1113 Downloaded OpenGL 2.0 render switcher from sources Pro Android 3 (guess chap 20) TestOpenGL example
  * 1113 (4) Learning OpenGL 2.0 ES http://www.learnopengles.com/android-lesson-one-getting-started/ and OpenGL 2.0 Programming Guide
  * 1112 (1) Writing documentation
  * 1111 (4) Compiling OBJ parser library- writing makefile, correcting errors in template functions and porting into it into simple OBJ parser
  * 1110 (2) Writing simple OBJ parser which displays just triangles using OpenGL
  * 1107 Leave the idea of finding designing software
  * 1107 Decided to implement the OBJ loader (problem->Plain OBJ does support that kind of animation, which I inteded to implement-..left as todo)
  * 1107 (2) Searching for OBJ loader, how to parse OBJ and still for knot designing software
  * 1106 (0.5) Setting up eclipse for [C++ development](http://mhandroid.wordpress.com/2011/01/23/using-eclipse-for-android-cc-development/) (I use includes for ndk version 8 and I am building for android 2.2 and for [C++ debugging](http://mhandroid.wordpress.com/2011/01/23/using-eclipse-for-android-cc-debugging/) with Android
  * 1106 (3) Starting learning blender and exporting first images
  * 1104 decided to **load** animations from  **OBJ format**
  * 1104 (2) searching for OBJ images and studying OBJ format http://www.martinreddy.net/gfx/3d/OBJ.spec
  * 1104 (0.5) connect handlers - affecting opengl animation with options
  * 1103 (1h)not founding knots, but found icons for my app
  * 1103 (1.5) redisign the options
  * 1102 (2h) looking for knots or knot designing software
  * 1031 (1.5) designing options menu