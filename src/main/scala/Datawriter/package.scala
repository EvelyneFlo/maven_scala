import org.apache.spark.sql.{DataFrame, SparkSession}

package object Datawriter {
  def writeData(dataframe: DataFrame, path: String){
    dataframe.write.format("csv").save(path)
  }
}
