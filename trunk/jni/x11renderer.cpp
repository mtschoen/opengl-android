#include <stdlib.h>
#include "esUtils.h"
#include "esX11Util.h"
#include "natRenderer.h"
#include "def.h"
#include "genCube.h"


void _escontext::setWidth(GLint w) {
        this->c->width = w;
}
void _escontext::setHeight(GLint h) {
        this->c->height = h;
}
GLint _escontext::height() {
        return this->c->height;
}
GLint _escontext::width() {
        return this->c->width;
}

void Init ( AppCtx * c ) {
    // Generate the vertex data
    esGenCube(1.0f, c); 

    // set initial state for OpenGL
    setupGraphics(c);

    // TODO should be called after resizing window
    viewValuesSetUp(c);
   printf("Setup Finish\n");
}


void Update ( AppCtx * c, float deltaTime ) {
   // TODO
//   rotateAnchor(c, dx, dy);
//   zoom(c,z);
}

void Draw ( AppCtx * c ) {
   renderFrame(c);
//   renderTestFrame(c);
//   renderTestFrame2(c);
}



int main ( int argc, char *argv[] ) {
   ESContext esContext;
   struct AppCtx c;

   esInitContext ( &esContext );
   esContext.c = &c;

   esCreateWindow ( &esContext, "Simple Texture 2D", 320, 240, ES_WINDOW_RGB );

   Init ( &c );

   esRegisterDrawFunc ( &esContext, Draw );
   esRegisterUpdateFunc ( &esContext, Update );

   esMainLoop ( &esContext );

}

