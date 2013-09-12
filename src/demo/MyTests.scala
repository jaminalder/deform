package demo

import scala.math._
import deform.library.Render._
import deform.library.Transforms._
import deform.library.Paths._
import deform.library.Shapes._
import deform.library.Textures._
import deform.library.TexturedShapes._
import deform.library.Colors._
import deform.library.Colors.ColorNames._
import deform.library.Drawings._
import deform._

class MyTests extends BaseScala {

  def circ = shape(List(path(t => Point(sin(t*2*Pi),cos(t*2*Pi)))))

  def triangle = {
    val a = Point(0,0)
    val b = Point(1,0.5)
    val c = Point(1,-0.5)
    shape(List(join(List(line(a, b), line(b, c), line(c, a)))))
  }
  def pacman = subtract(circ,triangle)
  def radgrad = texture(p=> lerp(red,p.normSquared,black))

  
  def draw(): Unit = {
    
    draw(scale(0.7) ** drawing(fill(circ, radgrad)))
    
  }

}

object MyTestsMain{
  def main(args: Array[String]): Unit = {
     new MyTests()
   }
}