package org.parboiled.peg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.parboiled.parserunners.ParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;
import org.parboiled.util.ParseUtils;

public class PegjsCosmosParserTest {

	public static void main(String[] args) throws Exception {

//		parseSQL("SELECT *\r\n" + "    FROM Families f\r\n" + "    WHERE f.id = 'AndersenFamily'");
//		parseSQL("SELECT {\"Name\":f.id, \"City\":f.address.city} AS Family\r\n" + //
//				" FROM Families f\r\n" + //
//				" WHERE f.address.city = f.address.state");

//      ---------------------Query with JOINS----------------------------------------------------	

//		parseSQL("SELECT c.givenName\r\n" + //
//				" FROM Families f\r\n" + //
//				" JOIN c IN f.children\r\n" + //
//				" WHERE f.id = 'WakefieldFamily'\r\n" + //
//				" ORDER BY f.address.city ASC");
//		parseSQL("SELECT Count(1) AS Count\r\n" + //
//				" FROM c\r\n" + //
//				" JOIN t IN c.tags\r\n" + //
//				" JOIN n IN c.nutrients\r\n" + //
//				" JOIN s IN c.servings\r\n" + //
//				" WHERE t.name = 'infant formula' AND " + //
//				" (n.nutritionValue > 0 \r\n" + //
//				" AND n.nutritionValue < 10) " + //
//				" AND s.amount > 1");

		// -------------------------Using IN keyword-----------------------------------

//		parseSQL("SELECT *\r\n" + "    FROM Families\r\n"
//				+ "    WHERE Families.id IN ('AndersenFamily', 'WakefieldFamily')");
//		parseSQL("SELECT *\r\n" + "    FROM Families\r\n"
//				+ "    WHERE Families.address.state IN (\"NY\", \"WA\", \"CA\", \"PA\", \"OH\", \"OR\", \"MI\", \"WI\", \"MN\", \"FL\")");
//		parseSQL("SELECT\r\n" + "  * \r\n" + "FROM\r\n" + "  products p\r\n" + "WHERE\r\n"
//				+ "  STARTSWITH(p.tags[0].slug, \"color-group-\") OR\r\n"
//				+ "  STARTSWITH(p.tags[1].slug, \"color-group-\") OR\r\n"
//				+ "  STARTSWITH(p.tags[2].slug, \"color-group-\")");
//		parseSQL("SELECT\r\n" + "  p.sku,\r\n" + "  t.name AS tag\r\n" + "FROM\r\n" + "  products p\r\n" + "JOIN\r\n"
//				+ "  t IN p.tags\r\n" + "WHERE\r\n" + "  STARTSWITH(t.slug, \"color-group-\")");
//		parseSQL("SELECT\r\n" + "  p.sku,\r\n" + "  t.name AS tag\r\n" + "FROM\r\n" + "  products p\r\n" + "JOIN\r\n"
//				+ "  t IN p.tags\r\n" + "WHERE\r\n" + "  p.categoryName = \"Sleeping Bags\" AND\r\n"
//				+ "  t.slug = \"bag-shape-mummy\"");
//
////      --------------------Using TOP Keyword---------------------------
//
//		parseSQL("SELECT TOP 10 n.id, n.description, n.nutritionValue, n.units, r.name\r\n" + "FROM food\r\n"
//				+ "JOIN n IN food.nutrients\r\n" + "JOIN r IN (\r\n" + "    SELECT VALUE [\r\n"
//				+ "        {unit: 'ng', name: 'nanogram', multiplier: 0.000000001, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'µg', name: 'microgram', multiplier: 0.000001, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'mg', name: 'milligram', multiplier: 0.001, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'g', name: 'gram', multiplier: 1, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'kg', name: 'kilogram', multiplier: 1000, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'Mg', name: 'megagram', multiplier: 1000000, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'Gg', name: 'gigagram', multiplier: 1000000000, baseUnit: 'gram'},\r\n"
//				+ "        {unit: 'nJ', name: 'nanojoule', multiplier: 0.000000001, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'µJ', name: 'microjoule', multiplier: 0.000001, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'mJ', name: 'millijoule', multiplier: 0.001, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'J', name: 'joule', multiplier: 1, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'kJ', name: 'kilojoule', multiplier: 1000, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'MJ', name: 'megajoule', multiplier: 1000000, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'GJ', name: 'gigajoule', multiplier: 1000000000, baseUnit: 'joule'},\r\n"
//				+ "        {unit: 'cal', name: 'calorie', multiplier: 1, baseUnit: 'calorie'},\r\n"
//				+ "        {unit: 'kcal', name: 'Calorie', multiplier: 1000, baseUnit: 'calorie'},\r\n"
//				+ "        {unit: 'IU', name: 'International units'}\r\n" + "    ]\r\n" + ")\r\n"
//				+ "WHERE n.units = r.unit");
//
////      --------------------Using COUNT---------------------------
//
//		parseSQL("SELECT TOP 5 Concat('id_', f.id) AS id\r\n" + "FROM food f");
//		parseSQL("SELECT TOP 5 \r\n" + "    f.id, \r\n"
//				+ "    (SELECT VALUE Count(1) FROM n IN f.nutrients WHERE n.units = 'mg'\r\n" + ") AS count_mg\r\n"
//				+ "FROM food f");
//		parseSQL("SELECT TOP 5 f.id, count_mg\r\n" + "FROM food f\r\n"
//				+ "JOIN (SELECT VALUE Count(1) FROM n IN f.nutrients WHERE n.units = 'mg') AS count_mg\r\n"
//				+ "WHERE count_mg > 20");
//		parseSQL(
//				"SELECT TOP 5 f.id, f.tags\r\n" + "FROM food f\r\n" + "WHERE ARRAY_CONTAINS(f.tags, {name: 'orange'})");
//
////		--------Using EXISTS-----------
//
//		parseSQL("SELECT TOP 5 f.id, f.tags\r\n" + "FROM food f\r\n"
//				+ "WHERE EXISTS(SELECT VALUE t FROM t IN f.tags WHERE t.name = 'orange')");
//
//		parseSQL("SELECT VALUE c.description\r\n" + "FROM c\r\n" + "JOIN n IN c.nutrients\r\n"
//				+ "WHERE n.units= \"mg\" AND n.nutritionValue > 0");
//
//		parseSQL("SELECT VALUE c.description\r\n" + "FROM c\r\n" + "WHERE EXISTS(\r\n" + "    SELECT VALUE n\r\n"
//				+ "    FROM n IN c.nutrients\r\n" + "    WHERE n.units = \"mg\" AND n.nutritionValue > 0\r\n" + ")");
//		parseSQL("SELECT\r\n" + "  p.sku,\r\n" + "  t.name AS tag\r\n" + "FROM\r\n" + "  products p\r\n" + "JOIN\r\n"
//				+ "  t IN p.tags");
//		parseSQL("SELECT\r\n" + "  p.id,\r\n" + "  p.sku,\r\n" + "  t.slug\r\n" + "FROM\r\n" + "  products p\r\n"
//				+ "JOIN\r\n" + "  t IN p.tags");
//		parseSQL("SELECT TOP 1 *\r\n" + "    FROM Families f");
//		parseSQL("SELECT *\r\n" + "    FROM Families.address.state");
//		parseSQL("SELECT *\r\n" + "    FROM Families.children");
//		parseSQL("SELECT *\r\n" + "    FROM Families.children[0] c\r\n" + "    WHERE c.grade % 2 = 1    \r\n" + "");
//		parseSQL("SELECT c.id, udf.GetMaxNutritionValue(c.nutrients) AS MaxNutritionValue\r\n" + "FROM c\r\n"
//				+ "WHERE udf.GetMaxNutritionValue(c.nutrients) > 100");
//		parseSQL("SELECT p.FirstName, p.LastName, a.City, cd.Detail\r\n" + "FROM Person p\r\n"
//				+ "JOIN ContactDetail cd ON cd.PersonId = p.Id\r\n"
//				+ "JOIN ContactDetailType cdt ON cdt.Id = cd.TypeId\r\n" + "JOIN Address a ON a.PersonId = p.Id");

//		parseSQL("select * from Test;");
//		parseSQL("select * from ABC;");
//		parseSQL("SELECT f.id, f.address.city\r\n" + "    FROM Family f\r\n" + "    ORDER BY f.address.city\r\n"
//				+ "    OFFSET 1 LIMIT 1");
////
////		--------This Nested query not Printing object-----------
//		parseSQL("SELECT COUNT(UniqueLastNames)\r\n" + "FROM (\r\n" + "SELECT AVG(f.age)\r\n" + "FROM f \r\n"
//				+ "GROUP BY f.lastName\r\n" + ") AS UniqueLastNames");
//		parseSQL("SELECT COUNT(1)\r\n" + "FROM (\r\n" + "SELECT AVG(f.age)\r\n" + "FROM f\r\n"
//				+ "GROUP BY f.lastName\r\n" + ")\r\n" + "");
//		parseSQL("SELECT COUNT(4)\r\n" + "FROM (\r\n" + "SELECT AVG(f.age)\r\n" + "FROM f\r\n"
//				+ "GROUP BY f.lastName\r\n" + ") AS UniqueLastNames\r\n" + "");
//		parseSQL("SELECT COUNT(4)\r\n" + "FROM (\r\n" + "SELECT AVG(f.age)\r\n" + "FROM f\r\n"
//				+ "GROUP BY f.lastName\r\n" + ")");
//		parseSQL("SELECT TOP 4 COUNT(1) \r\n"
//				+ "FROM(\r\n"
//				+ "SELECTAVG(f.foodGroup)\r\n"
//				+ "FROM Food f\r\n"
//				+ "GROUP BY f.foodGroup\r\n"
//				+ ") AS foodGroupCount\r\n"
//				+ "");
//		parseSQL("SELECT TOP 4 COUNT(1) \r\n"
//				+ "FROM(\r\n"
//				+ "SELECT AVG(f.foodGroup)\r\n"
//				+ "FROM Food f\r\n"
//				+ "GROUP BY f.foodGroup\r\n"
//				+ ") AS foodGroup");
////	----------------------------------------------------	
//		parseSQL("SELECT TOP 4 COUNT(1) \r\n"
//				+ "FROM(\r\n"
//				+ "SELECT AVG(f.foodGroup)\r\n"
//				+ "FROM Food f\r\n"
//				+ ")");
//		parseSQL("SELECT AVG(f.age)\r\n" + "FROM f\r\n" + "GROUP BY f.lastName\r\n" + ") AS UniqueLastNames");
//		parseSQL("SELECT COUNT(UniqueLastNames)\r\n" + "FROM cities");
//		parseSQL("SELECT COUNT(UniqueLastNames)\r\n" + "FROM f\r\n" + "GROUP BY f.lastName\r\n"
//				+ "AS UniqueLastNames\r\n" + "");
//		parseSQL("SELECT COUNT(UniqueLastNames)\r\n" + "FROM f\r\n" + "GROUP BY f.lastName\r\n" + "desc\r\n" + "");
//		parseSQL("SELECT COUNT(4)\r\n" + "FROM (\r\n" + "SELECT AVG(f.age)\r\n" + "FROM f\r\n" + ") \r\n" + "");
//		parseSQL("SELECT COUNT(UniqueLastNames)\r\n" + "FROM (\r\n" + "SELECT SUM(f.age)\r\n" + "FROM f \r\n"
//				+ "GROUP BY f.lastName\r\n" + ") AS UniqueLastNames");
//		parseSQL("SELECT COUNT(UniqueLastNames)\r\n" + "FROM (\r\n" + "SELECT MAX(f.age)\r\n" + "FROM f \r\n"
//				+ "GROUP BY f.lastName\r\n" + ") AS UniqueLastNames");
//// ----------------DISTINCT Keyword not supporting--------------			
//		parseSQL("SELECT DISTINCT VALUE f.lastName\r\n" + "FROM Families f");
//		parseSQL("SELECT f.id, ARRAY(SELECT DISTINCT VALUE c.givenName FROM c IN f.children) as ChildNames\r\n"
//				+ "FROM f");
//
//		parseSQL("SELECT f.id, ARRAY(SELECT DISTINCT VALUE c.givenName FROM c IN f.children) as ChildNames\r\n"
//				+ "FROM f");
//		parseSQL("SELECT COUNT(1) FROM (SELECT DISTINCT f.lastName FROM f)");
////-----------------------------------------------------------------------------
//		parseSQL("SELECT TOP 4 COUNT(1) AS foodGroupCount, f.foodGroup\r\n" + "FROM Food f\r\n"
//				+ "GROUP BY f.foodGroup");
//		parseSQL("SELECT TOP 1   f.id, ARRAY(SELECT VALUE t.name FROM t in f.tags) AS tagNames\r\n" + "FROM  food f");
//		parseSQL("SELECT Count(1) AS Count\r\n" + "FROM c\r\n" + "JOIN t IN c.tags\r\n" + "JOIN n IN c.nutrients\r\n"
//				+ "JOIN s IN c.servings\r\n" + "WHERE t.name = 'infant formula' AND (n.nutritionValue > 0 \r\n"
//				+ "AND n.nutritionValue < 10) AND s.amount > 1");
//
////		-----------using LIKE----------------	
//
//		parseSQL("SELECT *\r\n" + "FROM c\r\n" + "WHERE c.description LIKE \"%fruit%\"");
//
////    ----------------Using NOT LIKE----------------
//
//		parseSQL("SELECT *\r\n" + "FROM c\r\n" + "WHERE c.description NOT LIKE \"%fruit%\"");
//
////		-------Using the escape clause----------
//
//		parseSQL("SELECT *\r\n" + "FROM c\r\n" + "WHERE c.description LIKE '%20-30!%%' ESCAPE '!'");
//
////------------use the UDF qualified with the udf. prefix inside a filter----------------------
//
//		parseSQL("SELECT Families.id, Families.address.city\r\n" + "    FROM Families\r\n"
//				+ "    WHERE udf.REGEX_MATCH(Families.address.city, \".*eattle\")");
//
//		parseSQL("SELECT TOP 1000 c.id, MaxNutritionValue\r\n" + "FROM c\r\n"
//				+ "JOIN (SELECT VALUE udf.GetMaxNutritionValue(c.nutrients)) MaxNutritionValue\r\n"
//				+ "WHERE MaxNutritionValue > 100");
//
////-----------------Iteration------------------
//
//		parseSQL("SELECT *\r\n" + "FROM Families.children");
//
////-------------BETWEEN------------------
//
//		parseSQL("SELECT (c.grade BETWEEN 0 AND 10)\r\n" + "    FROM Families.children[0] c");
//
////------------------IN---------------------------
//
//		parseSQL("SELECT *\r\n" + "    FROM Families\r\n"
//				+ "    WHERE Families.id IN ('AndersenFamily', 'WakefieldFamily')");
//
////---------Operators--------------------
//
//		parseSQL("SELECT *\r\n" + "FROM c\r\n" + "WHERE 7 = 'a'");
//
//		parseSQL("SELECT (c.grade < 5)? \"elementary\": \"other\" AS gradeLevel\r\n"
//				+ "     FROM Families.children[0] c");
//
////------------Aggregate Functions-----------------
//
//		parseSQL("SELECT AVG(c.propertyA)\r\n" + "FROM c");
//		parseSQL("SELECT MAX(c.propertyA)\r\n" + "FROM c");
//		parseSQL("SELECT MIN(cities.propertyA)\r\n" + "FROM cities");
//		parseSQL("SELECT SUM(c.propertyA)\r\n" + "FROM c");
//
////          ------Array-------------
//
//		parseSQL("SELECT ARRAY_CONCAT([\"apples\", \"strawberries\"], [\"bananas\"]) AS arrayConcat");
//		parseSQL("SELECT f.id\r\n" + "FROM Families f\r\n"
//				+ "WHERE ST_DISTANCE(f.location, {'type': 'Point', 'coordinates':[31.9, -4.8]}) < 30000");
//		parseSQL("SELECT f.id\r\n" + "    FROM Families f\r\n"
//				+ "    WHERE ST_DISTANCE(f.location, {\"type\": \"Point\", \"coordinates\":[31.9, -4.8]}) < 30000");
//		parseSQL("SELECT c.InvoiceNumber\r\n" + "       ,c.Customer.Name \r\n" + "FROM   c\r\n"
//				+ "WHERE  ARRAY_CONTAINS(c.CustomerComments, \"Superb\")");
//
////   --------------parameterized Query---------------
//
//		parseSQL("SELECT *\r\n" + "    FROM Families f\r\n"
//				+ "    WHERE f.lastName = @lastName AND f.address.state = @addressState");
//		parseSQL("SELECT * FROM Families f WHERE f.lastName = @lastName AND f.address.state = @addressState\",\r\n"
//				+ "        \"parameters\": [\r\n"
//				+ "            {\"name\": \"@lastName\", \"value\": \"Wakefield\"},\r\n"
//				+ "            {\"name\": \"@addressState\", \"value\": \"NY\"},\r\n" + "        ]\r\n" + "    }");
//		parseSQL("SELECT TOP @n * FROM Family\",\r\n" + "        \"parameters\": [\r\n"
//				+ "            {\"name\": \"@n\", \"value\": 10},\r\n" + "        ]\r\n" + "    }");
//		parseSQL("SELECT VALUE child\r\n" + "    FROM child IN Parents.children");
//		parseSQL("SELECT *\r\n" + "    FROM Families f\r\n" + "    WHERE ({grade: f.children[0].grade}.grade > 3)");
//		parseSQL("SELECT VALUE {\"name\":f.children[0].familyName,\r\n"
//				+ "                  \"grade\": f.children[0].grade + 3 }\r\n" + "    FROM Families123 f");
//		parseSQL(
//				"SELECT ENDSWITH(\"abc\", \"b\", false) AS e1, ENDSWITH(\"abc\", \"bC\", false) AS e2, ENDSWITH(\"abc\", \"bC\", true) AS e3 from myhome");
//		parseSQL("SELECT TOP 1000 c.id, m.MaxNutritionValue\r\n" + "FROM c\r\n"
//				+ "JOIN (SELECT udf.GetMaxNutritionValue(c.nutrients) AS MaxNutritionValue) m\r\n"
//				+ "WHERE m.MaxNutritionValue > 100");
//		parseSQL("SELECT TOP 1000 c.id, AvgNutritionValue\r\n" + "FROM c\r\n"
//				+ "JOIN (SELECT VALUE avg(n.nutritionValue) FROM n IN c.nutrients) AvgNutritionValue\r\n"
//				+ "WHERE AvgNutritionValue > 80");
//		parseSQL("SELECT Count(1) AS Count\r\n" + "FROM c\r\n" + "JOIN t IN c.tags\r\n" + "JOIN n IN c.nutrients\r\n"
//				+ "JOIN s IN c.servings\r\n" + "WHERE t.name = 'infant formula' AND (n.nutritionValue > 0 \r\n"
//				+ "AND n.nutritionValue < 10) AND s.amount > 1");
//		parseSQL("SELECT TOP 1000 c1.id, AvgNutritionValue\r\n" + "FROM c1\r\n"
//				+ "JOIN (SELECT VALUE avg(n.nutritionValue) FROM n IN c1.nutrients) AvgNutritionValue\r\n"
//				+ "WHERE AvgNutritionValue > 80");
//		parseSQL("SELECT TOP 5 \r\n" + "    f.id, \r\n"
//				+ "    (SELECT VALUE Count(1) FROM n IN f.nutrients WHERE n.units = 'mg'\r\n" + ") AS count_mg\r\n"
//				+ "FROM food f");
//		parseSQL("SELECT a.Name\r\n" + "       ,{\"Make\": a.Make, \"Model\": a.Model\r\n"
//				+ "       , \"SellingPrice\": a.SellingPrice} AS InvoiceDetails\r\n" + "FROM\r\n"
//				+ "(SELECT  c.InvoiceNumber\r\n" + "       ,c.Customer.Name\r\n" + "       ,cx.LineItem\r\n"
//				+ "       ,cx.Make\r\n" + "       ,cx.Model\r\n" + "       ,cx.SellingPrice\r\n" + "FROM   c\r\n"
//				+ "JOIN   cx IN c.Salesdetails) a\r\n" + "");
//		parseSQL("SELECT\r\n" + "  * \r\n" + "FROM\r\n" + "  products p\r\n" + "WHERE\r\n"
//				+ "  STARTSWITH(p.tags[0].slug, \"color-group-\")");
//// ---------Queries that do not contain objects--------------------------
//// ----------------STRING Functions-----------------------------------
//		parseSQL("SELECT CONCAT(\"abc\", \"def\") AS concat from cities");
//		parseSQL("SELECT ARRAY_CONCAT([\"apples\", \"strawberries\"], [\"bananas\"]) AS arrayConcat;\r\n"
//				+ "");
//		parseSQL("SELECT   \r\n"
//				+ "           ARRAY_CONTAINS([\"apples\", \"strawberries\", \"bananas\"], \"apples\") AS b1,  \r\n"
//				+ "           ARRAY_CONTAINS([\"apples\", \"strawberries\", \"bananas\"], \"mangoes\") AS b2;\r\n"
//				+ "");
//		parseSQL("SELECT ARRAY_LENGTH([\"apples\", \"strawberries\", \"bananas\"]) AS len;\r\n"
//				+ "");
//		parseSQL("SELECT GetCurrentDateTime() AS currentUtcDateTime;\r\n"
//				+ "");
//		parseSQL("SELECT ABS(-1) AS abs1, ABS(0) AS abs2, ABS(1) AS abs3;\r\n"
//				+ "");
//		parseSQL("SELECT DEGREES(PI()/2) AS degrees;\r\n"
//				+ "");
//		parseSQL("SELECT POWER(2, 3) AS pow1, POWER(2.5, 3) AS pow2;\r\n"
//				+ "");
//		parseSQL("SELECT CONCAT(\"abc\", \"def\") AS concat;");
//		parseSQL("SELECT CONTAINS(\"abc\", \"ab\", false) AS c1, CONTAINS(\"abc\", \"A\", false) AS c2, CONTAINS(\"abc\", \"A\", true) AS c3");
//		parseSQL("SELECT ENDSWITH(\"abc\", \"b\", false) AS e1, ENDSWITH(\"abc\", \"bC\", false) AS e2, ENDSWITH(\"abc\", \"bC\", true) AS e3");
//		parseSQL("SELECT\r\n"
//				+ "    INDEX_OF(\"abc\", \"ab\") AS index_of_prefix,\r\n"
//				+ "    INDEX_OF(\"abc\", \"b\") AS index_of_middle,\r\n"
//				+ "    INDEX_OF(\"abc\", \"c\") AS index_of_last,\r\n"
//				+ "    INDEX_OF(\"abc\", \"d\") AS index_of_missing");
//		parseSQL("SELECT LEFT(\"abc\", 1) AS l1, LEFT(\"abc\", 2) AS l2");
//		parseSQL("SELECT REPLACE(\"This is a Test\", \"Test\", \"desk\") AS replace");
//		parseSQL("SELECT REVERSE(\"Abc\") AS reverse");
//		parseSQL("SELECT RTRIM(\"   abc\") AS t1, \r\n"
//				+ "RTRIM(\"   abc   \") AS t2, \r\n"
//				+ "RTRIM(\"abc   \") AS t3, \r\n"
//				+ "RTRIM(\"abc\") AS t4,\r\n"
//				+ "RTRIM(\"abc\", \"bc\") AS t5,\r\n"
//				+ "RTRIM(\"abc\", \"abc\") AS t6");
//		parseSQL("SELECT STARTSWITH(\"abc\", \"b\", false) AS s1, STARTSWITH(\"abc\", \"A\", false) AS s2, STARTSWITH(\"abc\", \"A\", true) AS s3");
//		parseSQL("SELECT \r\n"
//				+ "    StringToBoolean(\"true\") AS b1, \r\n"
//				+ "    StringToBoolean(\"    false\") AS b2,\r\n"
//				+ "    StringToBoolean(\"false    \") AS b3");
//		parseSQL("SELECT \r\n"
//				+ "    StringToNull(\"null\") AS n1, \r\n"
//				+ "    StringToNull(\"  null \") AS n2,\r\n"
//				+ "    IS_NULL(StringToNull(\"null   \")) AS n3");
//		parseSQL("SELECT \r\n"
//				+ "    StringToNumber(\"1.000000\") AS num1, \r\n"
//				+ "    StringToNumber(\"3.14\") AS num2,\r\n"
//				+ "    StringToNumber(\"   60   \") AS num3, \r\n"
//				+ "    StringToNumber(\"-1.79769e+308\") AS num4");
//		parseSQL("SELECT SUBSTRING(\"abc\", 1, 1) AS substring");
//		parseSQL("SELECT \r\n"
//				+ "    ToString(1.0000) AS str1, \r\n"
//				+ "    ToString(\"Hello World\") AS str2, \r\n"
//				+ "    ToString(NaN) AS str3, \r\n"
//				+ "    ToString(Infinity) AS str4,\r\n"
//				+ "    ToString(IS_STRING(ToString(undefined))) AS str5, \r\n"
//				+ "    ToString(0.1234) AS str6, \r\n"
//				+ "    ToString(false) AS str7, \r\n"
//				+ "    ToString(undefined) AS str8");
//		parseSQL("SELECT TRIM(\"   abc\") AS t1, \r\n"
//				+ "TRIM(\"   abc   \") AS t2, \r\n"
//				+ "TRIM(\"abc   \") AS t3, \r\n"
//				+ "TRIM(\"abc\") AS t4,\r\n"
//				+ "TRIM(\"abc\", \"ab\") AS t5,\r\n"
//				+ "TRIM(\"abc\", \"abc\") AS t6");
//		parseSQL("SELECT UPPER(\"Abc\") AS upper");
////----------------Mathematical Functiuons----------------------------------------------
//		parseSQL("SELECT ABS(-1) AS abs1, ABS(0) AS abs2, ABS(1) AS abs3");
//		parseSQL("SELECT ACOS(-1) AS acos");
//		parseSQL("SELECT CEILING(123.45) AS c1, CEILING(-123.45) AS c2, CEILING(0.0) AS c3");
//		parseSQL("SELECT DEGREES(PI()/2) AS degrees");
//		parseSQL("SELECT EXP(10) AS exp");
//		parseSQL("SELECT LOG(10) AS log");
//		parseSQL("SELECT POWER(2, 3) AS pow1, POWER(2.5, 3) AS pow2");
//		parseSQL("SELECT LOG10(100) AS log10");
//		parseSQL("SELECT RADIANS(-45.01) AS r1, RADIANS(-181.01) AS r2, RADIANS(0) AS r3, RADIANS(0.1472738) AS r4, RADIANS(197.1099392) AS r5");
//		parseSQL("SELECT RAND() AS rand");
//		parseSQL("SELECT ROUND(2.4) AS r1, ROUND(2.6) AS r2, ROUND(2.5) AS r3, ROUND(-2.4) AS r4, ROUND(-2.6) AS r5");
//		parseSQL("SELECT SIGN(-2) AS s1, SIGN(-1) AS s2, SIGN(0) AS s3, SIGN(1) AS s4, SIGN(2) AS s5");
//		parseSQL("SELECT SQUARE(1) AS s1, SQUARE(2.0) AS s2, SQUARE(3) AS s3");
//		parseSQL("SELECT SQRT(1) AS s1, SQRT(2.0) AS s2, SQRT(3) AS s3");
//		parseSQL("SELECT TRUNC(2.4) AS t1, TRUNC(2.6) AS t2, TRUNC(2.5) AS t3, TRUNC(-2.4) AS t4, TRUNC(-2.6) AS t5");
////---------------------spatial functions-----------------------------------
//		parseSQL("SELECT ST_AREA({\r\n"
//				+ "    \"type\":\"Polygon\",\r\n"
//				+ "    \"coordinates\":[ [\r\n"
//				+ "        [ 31.8, -5 ],\r\n"
//				+ "        [ 32, -5 ],\r\n"
//				+ "        [ 32, -4.7 ],\r\n"
//				+ "        [ 31.8, -4.7 ],\r\n"
//				+ "        [ 31.8, -5 ]\r\n"
//				+ "    ] ]\r\n"
//				+ "}) as Area");
//		parseSQL("SELECT f.id\r\n"
//				+ "FROM Families f\r\n"
//				+ "WHERE ST_DISTANCE(f.location, {'type': 'Point', 'coordinates':[31.9, -4.8]}) < 30000");
//		parseSQL("SELECT f.id\r\n"
//				+ "FROM Families f\r\n"
//				+ "WHERE ST_WITHIN(f.location, {  \r\n"
//				+ "    'type':'Polygon',\r\n"
//				+ "    'coordinates': [[[31.8, -5], [32, -5], [32, -4.7], [31.8, -4.7], [31.8, -5]]]  \r\n"
//				+ "})");
//		parseSQL("SELECT a.id\r\n"
//				+ "FROM Areas a\r\n"
//				+ "WHERE ST_INTERSECTS(a.location, {  \r\n"
//				+ "    'type':'Polygon',\r\n"
//				+ "    'coordinates': [[[31.8, -5], [32, -5], [32, -4.7], [31.8, -4.7], [31.8, -5]]]  \r\n"
//				+ "})");
//		parseSQL("SELECT ST_ISVALID({ \"type\": \"Point\", \"coordinates\": [31.9, -132.8] }) AS b");
//		parseSQL("SELECT ST_ISVALIDDETAILED({   \r\n"
//				+ "  \"type\": \"Polygon\",   \r\n"
//				+ "  \"coordinates\": [[ [ 31.8, -5 ], [ 31.8, -4.7 ], [ 32, -4.7 ], [ 32, -5 ] ]]  \r\n"
//				+ "}) AS b");
////------------------offset limit-------------------
//		parseSQL("SELECT f.id, f.address.city\r\n"
//				+ "    FROM Families f\r\n"
//				+ "    ORDER BY f.address.city\r\n"
//				+ "    OFFSET 1 LIMIT 1");
////-------------------Bitwise operators-----------
//		parseSQL("SELECT \r\n"
//				+ "    (100 >> 2) AS rightShift,\r\n"
//				+ "    (100 << 2) AS leftShift,\r\n"
//				+ "    (100 >>> 0) AS zeroFillRightShift,\r\n"
//				+ "    (100 & 1000) AS logicalAnd,\r\n"
//				+ "    (100 | 1000) AS logicalOr,\r\n"
//				+ "    (100 ^ 1000) AS logicalExclusiveOr");
////-------------------date and time functions-----------------------
//		parseSQL("SELECT DateTimeAdd(\"mm\", 1, \"2020-07-09T23:20:13.4575530Z\") AS OneMonthLater");
//		
////		parseSQL("SELECT DateTimeBin('2021-06-28T17:24:29.2991234Z','hh') AS BinByHour"); //exception
//		
//		parseSQL("SELECT DateTimeDiff(\"day\", \"2020-01-01T01:02:03.1234527Z\", \"2020-01-03T01:02:03.1234567Z\") AS DifferenceInDays");
//		parseSQL("SELECT DateTimeFromParts(2020, 9, 4) AS DateTime");
//		parseSQL("SELECT DateTimePart(\"m\", \"2020-01-02T03:04:05.6789123Z\") AS MonthValue");
//		parseSQL("SELECT DateTimeToTimestamp(\"2020-07-09T23:20:13.4575530Z\") AS Timestamp");
//		parseSQL("SELECT TicksToDateTime(15943368134575530) AS DateTime");
//		parseSQL("SELECT TimestampToDateTime(1594227912345) AS DateTime");
//		parseSQL("SELECT DateTimeAdd(\"mm\", 1, \"2020-07-09T23:20:13.4575530Z\") AS OneMonthLater");
//		parseSQL("SELECT GetCurrentTicks() AS CurrentTimeInTicks");
//		parseSQL("SELECT GetCurrentTimestamp() AS currentUtcTimestamp");
////---------------Type checking Functions----------------------
//		parseSQL("SELECT   \r\n"
//				+ " IS_ARRAY(true) AS isArray1,   \r\n"
//				+ " IS_ARRAY(1) AS isArray2,  \r\n"
//				+ " IS_ARRAY(\"value\") AS isArray3,  \r\n"
//				+ " IS_ARRAY(null) AS isArray4,  \r\n"
//				+ " IS_ARRAY({prop: \"value\"}) AS isArray5,   \r\n"
//				+ " IS_ARRAY([1, 2, 3]) AS isArray6,  \r\n"
//				+ " IS_ARRAY({prop: \"value\"}.prop2) AS isArray7");
//		parseSQL("SELECT   \r\n"
//				+ "    IS_BOOL(true) AS isBool1,   \r\n"
//				+ "    IS_BOOL(1) AS isBool2,  \r\n"
//				+ "    IS_BOOL(\"value\") AS isBool3,   \r\n"
//				+ "    IS_BOOL(null) AS isBool4,  \r\n"
//				+ "    IS_BOOL({prop: \"value\"}) AS isBool5,   \r\n"
//				+ "    IS_BOOL([1, 2, 3]) AS isBool6,  \r\n"
//				+ "    IS_BOOL({prop: \"value\"}.prop2) AS isBool7");
//		parseSQL("SELECT IS_DEFINED({ \"a\" : 5 }.a) AS isDefined1, IS_DEFINED({ \"a\" : 5 }.b) AS isDefined2");
//		parseSQL("SELECT   \r\n"
//				+ "    IS_NULL(true) AS isNull1,   \r\n"
//				+ "    IS_NULL(1) AS isNull2,  \r\n"
//				+ "    IS_NULL(\"value\") AS isNull3,   \r\n"
//				+ "    IS_NULL(null) AS isNull4,  \r\n"
//				+ "    IS_NULL({prop: \"value\"}) AS isNull5,   \r\n"
//				+ "    IS_NULL([1, 2, 3]) AS isNull6,  \r\n"
//				+ "    IS_NULL({prop: \"value\"}.prop2) AS isNull7");
//		parseSQL("SELECT   \r\n"
//				+ "    IS_NUMBER(true) AS isBooleanANumber,   \r\n"
//				+ "    IS_NUMBER(1) AS isNumberANumber, \r\n"
//				+ "    IS_NUMBER(\"value\") AS isTextStringANumber, \r\n"
//				+ "    IS_NUMBER(\"1\") AS isNumberStringANumber,\r\n"
//				+ "    IS_NUMBER(null) AS isNullANumber,  \r\n"
//				+ "    IS_NUMBER({prop: \"value\"}) AS isObjectANumber,   \r\n"
//				+ "    IS_NUMBER([1, 2, 3]) AS isArrayANumber,  \r\n"
//				+ "    IS_NUMBER({stringProp: \"value\"}.stringProp) AS isObjectStringPropertyANumber, \r\n"
//				+ "    IS_NUMBER({numberProp: 1}.numberProp) AS isObjectNumberPropertyANumber");
//		parseSQL("SELECT   \r\n"
//				+ "    IS_OBJECT(true) AS isObj1,   \r\n"
//				+ "    IS_OBJECT(1) AS isObj2,  \r\n"
//				+ "    IS_OBJECT(\"value\") AS isObj3,   \r\n"
//				+ "    IS_OBJECT(null) AS isObj4,  \r\n"
//				+ "    IS_OBJECT({prop: \"value\"}) AS isObj5,   \r\n"
//				+ "    IS_OBJECT([1, 2, 3]) AS isObj6,  \r\n"
//				+ "    IS_OBJECT({prop: \"value\"}.prop2) AS isObj7");
//		parseSQL("SELECT   \r\n"
//				+ "           IS_PRIMITIVE(true) AS isPrim1,   \r\n"
//				+ "           IS_PRIMITIVE(1) AS isPrim2,  \r\n"
//				+ "           IS_PRIMITIVE(\"value\") AS isPrim3,   \r\n"
//				+ "           IS_PRIMITIVE(null) AS isPrim4,  \r\n"
//				+ "           IS_PRIMITIVE({prop: \"value\"}) AS isPrim5,   \r\n"
//				+ "           IS_PRIMITIVE([1, 2, 3]) AS isPrim6,  \r\n"
//				+ "           IS_PRIMITIVE({prop: \"value\"}.prop2) AS isPrim7");
//		parseSQL("SELECT   \r\n"
//				+ "       IS_STRING(true) AS isStr1,   \r\n"
//				+ "       IS_STRING(1) AS isStr2,  \r\n"
//				+ "       IS_STRING(\"value\") AS isStr3,   \r\n"
//				+ "       IS_STRING(null) AS isStr4,  \r\n"
//				+ "       IS_STRING({prop: \"value\"}) AS isStr5,   \r\n"
//				+ "       IS_STRING([1, 2, 3]) AS isStr6,  \r\n"
//				+ "       IS_STRING({prop: \"value\"}.prop2) AS isStr7");
//
//// --------Scalar Expressions---------------
//
//		parseSQL("SELECT ((2 + 11 % 7)-2)/3");
//		parseSQL("SELECT 1 AS a, 2 AS b");
//		parseSQL("SELECT (SELECT VALUE 1) AS a, (SELECT VALUE 2) AS b");
//		parseSQL("SELECT (SELECT VALUE 1) AS a, (SELECT VALUE 2) AS b");
//		parseSQL("SELECT EXISTS (SELECT VALUE undefined)");
//		
//		parseSQL("SELECT DISTINCT VALUE c.name\r\n"
//				+ "FROM c\r\n"
//				+ "ORDER BY c.name");
//
////-----------LINQ to SQL---------
//
//		parseSQL("SELECT VALUE f.parents[0].familyName\r\n"
//				+ "    FROM Families f");
//		parseSQL("SELECT VALUE f.children[0].grade + c\r\n"
//				+ "    FROM Families f");
//		parseSQL("SELECT VALUE {\"name\":f.children[0].familyName,\r\n"
//				+ "                  \"grade\": f.children[0].grade + 3 }\r\n"
//				+ "    FROM Families f");
//		parseSQL("SELECT *\r\n"
//				+ "    FROM Families f\r\n"
//				+ "    WHERE f.parents[0].familyName = \"Wakefield\"\r\n"
//				+ "    AND f.children[0].grade < 3");
//
////----------composite SQL query-------
//
//		parseSQL("SELECT *\r\n"
//				+ "    FROM Families f\r\n"
//				+ "    WHERE f.parents[0].familyName = \"Wakefield\"");
//		parseSQL("SELECT *\r\n"
//				+ "    FROM Families f\r\n"
//				+ "    JOIN c IN f.children\r\n"
//				+ "    WHERE c.familyName = f.parents[0].familyName");

	}

	public static void parseSQL(String sql) throws Exception {

		System.out.println("--------------------------------------------");
		System.out.println("sql : " + sql);
		System.out.println("--------------------------------------------");

		ParseRunner<?> runner = ParseUtils.createParseRunner(false, PegjsCosmosParser.class);
//		ParseRunner<?> runner = ParseUtils.createParseRunner(true, PegBigQueryParser.class);

		ParsingResult<?> result = runner.run(sql);

		if (result.parseErrors.size() == 0) {

			System.out.println("tree : ");
			printTree(result);

			List<Map<String, Object>> verbObjectMapList = prepareVerbObjectMap(result);
			System.out.println("verbObjectMapList : " + verbObjectMapList);

			verbObjectMapList.forEach(PegjsCosmosParserTest::cleanVerbs);
			System.out.println("verbObjectMapList-cleaned : " + verbObjectMapList);

		} else {
			throw new RuntimeException("not matched : " + sql);
		}
		System.out.println("--------------------------------------------");

	}

	private static void printTree(ParsingResult<?> result) {

		ParseUtils.visitTree(result.parseTreeRoot, (node, level) -> {
//			if ("select".equals(node.getLabel()) //
//					|| "collection_primary_expression".equals(node.getLabel()) //
//					|| "collection_member_expression".equals(node.getLabel()) //
//					|| "SEMICOLON".equals(node.getLabel())) {
			System.out.print(level + " : ");
			for (int i = 0; i < level; i++) {
				System.out.print(" ");
			}
			String value = ParseTreeUtils.getNodeText(node, result.inputBuffer).trim();
			System.out.println(node.getLabel() + " : " + value);
//			}
			return true;
		});
	}

	@SuppressWarnings("unchecked")
	private static List<Map<String, Object>> prepareVerbObjectMap(ParsingResult<?> result) {

		List<Map<String, Object>> verbObjectMapList = new ArrayList<>();
		Stack<Integer> verbLevelStack = new Stack<>();
		Stack<Map<String, Object>> verbObjectMapStack = new Stack<>();

		ParseUtils.visitTree(result.parseTreeRoot, (node, level) -> {

			String label = node.getLabel();
			// String verb = VERB_LABEL_MAPPING.get(label);

			if ("select".equals(label)) {
				if (verbLevelStack.size() == 0) {
					Map<String, Object> verbObjectMap = new HashMap<>();
					verbObjectMap.put("verb", label);
					verbObjectMapStack.push(verbObjectMap);
					verbObjectMapList.add(verbObjectMap);
				} else {
					Map<String, Object> parentVerbObjectMap = getParentMap(level, verbLevelStack, verbObjectMapStack);
					List<Map<?, ?>> descMapList = (List<Map<?, ?>>) parentVerbObjectMap.get("descs");
					if (descMapList == null) {
						descMapList = new LinkedList<>();
						parentVerbObjectMap.put("descs", descMapList);
					}
					Map<String, Object> descMap = new HashMap<>();
					descMap.put("verb", label);
					verbObjectMapStack.push(descMap);
					descMapList.add(descMap);
				}
				verbLevelStack.push(level);

			} else if ("collection_primary_expression".equals(label) || "collection_member_expression".equals(label)) {
				String object = ParseTreeUtils.getNodeText(node, result.inputBuffer);

				Map<String, Object> parentVerbObjectMap = getParentMap(level, verbLevelStack, verbObjectMapStack);
				Set<String> objectList = (Set<String>) parentVerbObjectMap.get("objects");
				if (objectList == null) {
					objectList = new HashSet<>();
					parentVerbObjectMap.put("objects", objectList);
				}
				objectList.add(object);

			} else if ("SEMICOLON".equals(label)) {
				verbLevelStack.clear();
				verbObjectMapStack.clear();
			}
			return true;
		});
		return verbObjectMapList;
	}

	public static Map<String, Object> getParentMap(Integer level, Stack<Integer> verbLevelStack,
			Stack<Map<String, Object>> verbObjectMapStack) {
		int parentVerbLevel = verbLevelStack.peek();
		Map<String, Object> parentVerbObjectMap = verbObjectMapStack.peek();

		if (level < parentVerbLevel) {
			while (level < parentVerbLevel) {
				parentVerbLevel = verbLevelStack.pop();
				parentVerbObjectMap = verbObjectMapStack.pop();
			}
			verbLevelStack.push(parentVerbLevel);
			verbObjectMapStack.push(parentVerbObjectMap);
		}
		return parentVerbObjectMap;
	}

	@SuppressWarnings("unchecked")
	private static Map<?, ?> cleanVerbs(Map<?, ?> verbObjectMap) {

		List<Map<?, ?>> descMapList = (List<Map<?, ?>>) verbObjectMap.get("descs");
		if (descMapList != null) {
			for (Iterator<?> iterator = descMapList.iterator(); iterator.hasNext();) {
				Map<?, ?> descMap = (Map<?, ?>) iterator.next();

				descMap = cleanVerbs(descMap);
				if (descMap == null) {
					iterator.remove();
				}

			}
		}
		if (descMapList == null || descMapList.isEmpty()) {
			verbObjectMap.remove("descs");
			Set<String> objectList = (Set<String>) verbObjectMap.get("objects");
			if (objectList == null) {
				return null;
			}
		}

		return verbObjectMap;

	}

}
