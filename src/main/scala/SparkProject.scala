import org.apache.spark.sql.SparkSession
import Datareader.readData
import Datawriter.writeData
import Transformations.functions

object SparkProject {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .master("local[4]")
      .appName("Moja-applikacja")
      .getOrCreate()

    val actorsDf = readData(spark, args(0));
    val namesDf = readData(spark, args(1));
    val actorsFiltered = actorsDf.filter(row => functions.specificJob(row, "producer"))
    val namesFiltered = namesDf.filter(row => functions.heightMoreThan(row, 165))

    actorsFiltered.show()
    namesFiltered.show()
    writeData(actorsFiltered, args(2));
    writeData(namesFiltered, args(3));
  }
}
