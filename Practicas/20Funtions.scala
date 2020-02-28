
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Sales.csv")

df.printSchema()

df.show()

//1
df.describe ("High").show //Describe the statistical values ​​of the selected column
//2 
df.select ("High","Close").show // Displays the related values ​​of the consulted columns.
//3 
df.select ("Open","Low").filter("Close < 480").show // Display the related and selected columns and put a filter to only display those that are less than 480
//4 
df.groupBy ("Open").show
//5
df.first //   return the first column of the dataframe
//6 
df.columns // Returns the dataframe columns
//7 
val df2 = df.withColumn("HV Ratio", df("High")+df("Volume")) // Add a column that derives from the high and Volume column
//8 
df.select(min("Volume")).show() // Choose the volume column min
//9 
df.select(max("Volume")).show() // Choose the volume column max
//10
val df2 = df.withColumn("Year", year(df("Date"))) // create the year column from the date column