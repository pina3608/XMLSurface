This is information about buidling and running XMLSurface from 
the source code.

To build XMLSurface, you can use Ant with the build.xml file. Download the ant
distribution from http://jakarta.apache.org.

Look at the setclasspath.csh file for an example of what you will
need to have in your classpath to build Xerlin. To actually build,
type  "ant" from the src directory. 

To run XMLSurface, you can use Xerlin.bat or Xerlin.sh or use the
commandline "java org.merlotxml.merlot.XMLEditor"

The source is organized into a couple of packages:

org.merlotxml.
    awt:     The PercentLayout LayoutManager
    merlot:  The main xerlin source
    plugin:  Plugin support classes
    util:    Utility classes used by xerlin, 
             including the xml parser adapters

The "lib" directory contains some third-party sources required
by XMLSurface, along with some patches for those 
third-party components. The license files for these thirdparty
sources are located in the doc directory.

Xerlin currently uses Apache's Xerces as it's parser. 

One of the main layout managers XMLSurface uses is a patched version
of Matthew Phillips' StrutLayout class. The unpatched version is
available from

http://www.ozemail.com.au/~mpp/strutlayout/doc/overview.html

The patched version is included as StrutLayout-1.2.1.


We also use as one of our components, Sun's JTreeTable available
from The Swing Connection:

http://java.sun.com/products/jfc/tsc/articles/treetable2/

