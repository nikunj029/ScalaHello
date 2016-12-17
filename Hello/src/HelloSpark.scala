/**
  * Created by Nikunj on 12/17/2016.
  */
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object HelloSpark {
  def main(args: Array[String]) {
    val logFile = "C:/Users/Nikunj/IdeaProjects/ScalaHello/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(x => x.contains("a")).count()
    val numBs = logData.filter(x => x.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    println(logData)
  }
}
