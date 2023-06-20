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

public class PegjsMySqlParserTest {

	public static void main(String[] args) throws Exception {

		// --------------------------------Inner Join---------------------------
//
//		parseSQL("SELECT Table1.Letter, Table2.Number FROM Table1 INNER JOIN Table2 ON Table1.ID = Table2.ID");
//
//		parseSQL("SELECT E.Name, C.Name\r\n" + "FROM Sample.Employee AS E\r\n" + "INNER JOIN Sample.Company AS C\r\n"
//				+ "ON E.CompanyID = C.CompanyID");
//
//		parseSQL("SELECT E.Name, C.Name\r\n" + "FROM Sample.Employee AS E\r\n" + "INNER JOIN Sample.Company AS C\r\n"
//				+ "ON E.CompanyID = C.CompanyID AND E.Age > 20");
//
//		// ------- left outer join ------------------
//		parseSQL("SELECT Table1.Letter, Table2.Number\r\n" + "FROM Table1\r\n" + "LEFT OUTER JOIN Table2\r\n"
//				+ "ON Table1.ID = Table2.ID");
//
//		parseSQL("SELECT E.Name, C.Name\r\n" + "FROM Sample.Employee AS E\r\n"
//				+ "LEFT OUTER JOIN Sample.Company AS C\r\n" + "ON E.CompanyID = C.CompanyID");
//
//		parseSQL("SELECT E.Name, C.Name\r\n" + "FROM Sample.Employee AS E\r\n"
//				+ "LEFT OUTER JOIN Sample.Company AS C\r\n" + "USING (CompanyID)");
//
//		// ------------------------ right outer join --------------------------------
//		parseSQL("SELECT Table1.Letter, Table2.Number\r\n" + "FROM Table1\r\n" + "RIGHT OUTER JOIN Table2\r\n"
//				+ "ON Table1.ID = Table2.ID");
//		parseSQL("SELECT E.Name, C.Name\r\n" + "FROM Sample.Employee AS E\r\n"
//				+ "LEFT OUTER JOIN Sample.Company AS C\r\n" + "ON E.CompanyID = C.CompanyID");
//		parseSQL("SELECT E.Name, C.Name\r\n" + "FROM Sample.Employee AS E\r\n"
//				+ "RIGHT OUTER JOIN Sample.Company AS C\r\n" + "USING (CompanyID)");
//
//		// --------------------full outer join---------------------------------
//		parseSQL("SELECT Table1.Letter, Table2.Number\r\n" + "FROM Table1\r\n" + "FULL OUTER JOIN Table2\r\n"
//				+ "ON Table1.ID = Table2.ID");
//		parseSQL("SELECT P.Name, E.Company\r\n" + "FROM Sample.Person AS P\r\n" + "INNER JOIN Sample.Employee AS E\r\n"
//				+ "ON P.PersonID = E.PersonID");
//
//		// -----------------------------------Cross join--------------------------------
//		parseSQL("SELECT Table1.Letter, Table2.Number\r\n" + "FROM Table1\r\n" + "CROSS JOIN Table2");
//
//		parseSQL("SELECT * FROM Sample.LettersAtoZ CROSS JOIN Sample.Numbers1to10");
//
//		// ---------------------------------------------------------revoke---------------------------------------
//		
//		parseSQL("DELETE FROM CUSTOMERS WHERE ID=1");
//
//		// -------------------------Select Retrieve row --------------------------------
//		
//		parseSQL("SELECT * FROM Sample.Person");
//		parseSQL("SELECT Name,Age,Home_State FROM Sample.Person WHERE Age > 40 AND Home_State = 'MA'");
//		parseSQL("Select Home_State AS US_State_Abbrev FROM Sample.Person");
//		parseSQL("SELECT DISTINCT Home_State,Age FROM Sample.Person");
//
//		parseSQL("CREATE TABLE Sample.Person (\r\n" + "    Name VARCHAR(30),\r\n" + "    DateOfBirth TIMESTAMP)");
//		parseSQL("SELECT\r\n" + "CASE\r\n" + "  WHEN Field1 = 1 THEN 'ONE'\r\n" + "  WHEN Field1 = 2 THEN 'TWO'\r\n"
//				+ "  ELSE NULL\r\n" + "END\r\n" + "FROM MyTable");
//
//		// -------------Insert OR Update----------------------
//
//		// ----------------------------------Insert------------------------------------
//		parseSQL("INSERT INTO Sample.Company1 VALUES ('CompanyA',10000,'BEL')");
//		parseSQL("INSERT INTO Sample.Company1 (Name,Country) VALUES ('CompanyB','CAN')");
//		parseSQL("INSERT INTO Sample.Company1 Set Name = 'CompanyC', Country = 'ECU', Revenue = 25000");
//		parseSQL("INSERT INTO MyStudents1 (StudentName,StudentDOB)\r\n" + "SELECT Name,DateOfBirth FROM Sample.Person");
//
//		// ---------------------------------- trigger-----------------------------------
//
//		parseSQL("CREATE TRIGGER Student_Tale_Marks  \r\n" + "BEFORE INSERT  \r\n" + "ON  \r\n"
//				+ "Student_Trigger  \r\n" + "FOR EACH ROW  \r\n"
//				+ "SET new.Student_TotalMarks = new.Student_EnglishMarks + new.Student_PhysicsMarks + new.Student_ChemistryMarks + new.Student_MathsMarks,   \r\n"
//				+ "new.Student_Percentage = ( new.Student_TotalMarks / 400) * 100");
//
//		parseSQL("DROP TRIGGER EmployNameTrig");
//
//		// -----------------------------------  table --------------------------
//
//		parseSQL("CREATE TABLE Employee24 (\r\n" + "    EmpNum INT NOT NULL AUTO_INCREMENT,\r\n"
//				+ "    NameLast CHAR(30) NOT NULL,\r\n" + "    NameFirst CHAR(30) NOT NULL,\r\n"
//				+ "    StartDate TIMESTAMP,\r\n" + "    AccruedVacation INT,\r\n" + "    AccruedSickLeave INT,\r\n"
//				+ "    CONSTRAINT EMPLOYEEPK PRIMARY KEY (EmpNum))");
//		
//
//		parseSQL("DROP TABLE Employee24");
//
//		parseSQL("CREATE SCHEMA Sample1");
//		parseSQL("DROP SCHEMA Sample1");
//		
//		// ------------------- user ------------------
//
//		// --------------------- role--------------------------
//
//		// ----------------------- Create query -----------------------------------
//
//		// --------------------- Create Index--------------------------
//
//		// -------------------------- Create Function -------------------------------
//		// --------------------------- Create Database----------------------
//		parseSQL("CREATE DATABASE db2");
//		parseSQL("DROP DATABASE db2");
//		parseSQL("USE db2");
//
//		// ---------------------------- create Aggregate -----------------------------
//		// ------------------------------------ DELETE -------------------------------
//		parseSQL("DELETE FROM TempEmployees");
//		parseSQL("DELETE\r\n" + "     FROM Employees\r\n" + "     WHERE EmpId = 234");
//		parseSQL("DELETE FROM ActiveEmployees\r\n" + "     WHERE CurStatus = 'Retired'");
//		parseSQL("DELETE FROM (SELECT Name,Age FROM Sample.Person WHERE Age > 65)");
//
//		// ------------------------------ create view --------------------------
//		parseSQL("CREATE VIEW CityPhoneBook AS\r\n" + "SELECT Name FROM PhoneBook WHERE City='Boston'");
//		parseSQL("CREATE VIEW MassFolks (vFullName) AS \r\n"
//				+ "    SELECT Name FROM Sample.Person WHERE Home_State='MA'");
//		// -------------------------------- Alter view-------------------------
//		parseSQL("DROP VIEW MassFolks");
//
//		// ----------------------------------- CASE ------------------------
//		parseSQL("SELECT Name,\r\n" + "CASE Age\r\n" + "  WHEN 65 THEN 'Retire this year'\r\n"
//				+ "  WHEN 64 THEN 'Retire next year' \r\n" + "  ELSE 'Past retirement age '|| Age\r\n"
//				+ "END RetireAge\r\n" + "FROM Sample.Person\r\n" + "WHERE Age > 63\r\n" + "ORDER BY Age");
//
//		// ----------------------- Foreign Table ------------------------
//
//		// ------------------------ Drop function ---------------------
//
//		// -------------------------- Procedure -----------------
//
//		// --------------------- Load Data --------------------------
//
//		// ------------------------------------------------
//		// ------------------------ Predicate -------------------------
//		// ------------------------------------------------
//		
//		parseSQL("SELECT Age,AVG(Age) AS AvgAge FROM Sample.Person GROUP BY ROUND(Age,-1)");
//		// --------------------------- All --------------------
//		
//		// --------------------------- ANY -------------------
//		parseSQL("SELECT Name,Salary,Home_State FROM Sample.Employee\r\n" + "WHERE Salary > 75000\r\n"
//				+ "AND Home_State = ANY\r\n" + " (SELECT State FROM Sample.USZipCode\r\n"
//				+ "  WHERE Longitude < -93)\r\n" + "ORDER BY Home_State");
//		
//		// ---------------------------- BETWEEN -------------------
//		parseSQL("SELECT Name,Age FROM Sample.Person\r\n" + "WHERE Age BETWEEN 18 AND 21\r\n" + "ORDER BY Age");
//
//		// ------------------ EXIST ----------------------
//		parseSQL("SELECT name\r\n" + "     FROM Table_A\r\n" + "     WHERE EXISTS\r\n" + "     (SELECT *\r\n"
//				+ "          FROM Table_B\r\n" + "          WHERE Table_B.Number = Table_A.Number)");
//		parseSQL("SELECT EmployeeName,Age\r\n" + "     FROM Employees\r\n"
//				+ "     WHERE NOT EXISTS (SELECT * FROM BonusTable\r\n"
//				+ "     WHERE NOT (BonusTable.Result = 'Positive'\r\n"
//				+ "     AND Employees.EmployeeNum = BonusTable.EmployeeNum))");
//		
//		// ------------------ FOR SOME ------------------------------
//
//		// ------------------------- IN -------------------
//		parseSQL("SELECT Name, Home_State FROM Sample.Person\r\n" + "WHERE Home_State IN ('ME','nH','VT')");
//		
//		// -----------------------IS NULL -----------------------
//		parseSQL("SELECT Name, FavoriteColors FROM Sample.Person\r\n" + "WHERE FavoriteColors IS NULL ");
//		parseSQL("SELECT Name, FavoriteColors FROM Sample.Person\r\n" + "WHERE FavoriteColors IS NOT NULL");
//		// --------------------- LIKE ---------------------
//		parseSQL("SELECT Name FROM Sample.Person\r\n" + "WHERE Name LIKE '%Ro%'");
//		parseSQL("SELECT Name,FavoriteColors FROM Sample.Person\r\n" + "WHERE FavoriteColors LIKE '%blue%'");
//		// ---------------- SOME --------------------
//		parseSQL("SELECT Name,Salary,Home_State FROM Sample.Employee\r\n" + "WHERE Salary > 75000\r\n"
//				+ "AND Home_State = SOME\r\n" + " (SELECT State FROM Sample.USZipCode\r\n"
//				+ "  WHERE Longitude < -93)\r\n" + "ORDER BY Home_State");
//
//		// ------------------------------------------------------------------------------------------
//		// STANDARD SQL Clause
//		// ------------------------------------------------------------------------------------------
//		// --------------------------- DISTINCT ----------------------
//		parseSQL("SELECT DISTINCT Home_State,Age FROM Sample.Person");
//
//		// ----------------- FROM ----------------
//
//		parseSQL("SELECT e.Name,c.Name\r\n" + "FROM Sample.Company AS c,Sample.Employee AS e");
//		parseSQL("SELECT name,region\r\n" + "FROM (SELECT t1.name,t1.state,t2.region\r\n"
//				+ "      FROM Employees AS t1 LEFT OUTER JOIN Regions AS t2\r\n" //
//				+ "      ON t1.state=t2.state)\r\n" //
//				+ "GROUP BY region");
//
//		// --------------------- Top----------------------------
//
//		// ------------------------ Having -------------------------------------
//		parseSQL("SELECT Name,Age,AVG(Age) AS AvgAge\r\n" + "FROM Sample.Person\r\n" + "HAVING Age > AVG(Age)\r\n"
//				+ "ORDER BY Age");
//		parseSQL("SELECT Name, Home_State FROM Sample.Person\r\n" + "GROUP BY Home_State\r\n"
//				+ "HAVING Home_State IN ('ME','NH','VT','MA','RI','CT')");
//
//		parseSQL("SELECT Name,Home_State FROM Sample.Person\r\n" //
//				+ "HAVING Name IN \r\n" + " (SELECT Name FROM Sample.Employee\r\n" //
//				+ " HAVING Salary < 50000)");
//
//		// --------------------------------- INTO --------------------------
//		parseSQL("SELECT * INTO CustomersBackup2017\r\n" + "FROM Customers");
//
//		// ---------------------------------- ORDER BY ------------------------------
//		parseSQL("SELECT Name, AVG(Age) AS AvgAge, Home_State\r\n" + "FROM Sample.Person\r\n"
//				+ "GROUP BY Home_State\r\n" + "ORDER BY AvgAge");
//		parseSQL("SELECT Name,Age,Home_State\r\n" + "FROM Sample.Person\r\n" + "ORDER BY Home_State");
//		parseSQL("SELECT Name,Age,Home_State\r\n" + "FROM Sample.Person\r\n" + "ORDER BY Home_State DESC");
//
//		// -------------------------------- UNION ---------------------
//		parseSQL("SELECT Name,Salary,BirthDate\r\n" + "FROM Sample.Employee\r\n" + "UNION ALL\r\n"
//				+ "SELECT Name,NULL,BirthDate\r\n" + "FROM Sample.Person");
//		parseSQL("SELECT MyTinyIntField FROM Table1\r\n" + "     UNION ALL\r\n" + "SELECT MyDateField FROM Table2");
//
//		// ------------------------------- VALUES ----------------------------
//		parseSQL("INSERT INTO Sample.Person VALUES (5,'John')");
//		parseSQL("INSERT INTO Sample.Person (Age,Name) VALUES (5,'John')");
//		parseSQL("INSERT INTO Sample.Person\r\n" + "(SSN,Name,Home_City) VALUES ('123-45-6789','Doe,John',NULL)");
//		
//		// ----------------------------------------------------
//		// ----- Not Working - Half Tree
//		// ----------------------------------------------------
//		
//		parseSQL("SELECT TOP 10 Name FROM Sample.Person ORDER BY Name ASC");
//		parseSQL("SELECT TOP 20 Home_State,Name FROM Sample.Person");
//		parseSQL("SELECT DISTINCT TOP 20 Home_State FROM Sample.Person ORDER BY Home_State");
//		parseSQL("SELECT DISTINCT TOP 40 FavoriteColors FROM Sample.Person \r\n" + //
//				"      ORDER BY FavoriteColors DESC");
//
//		parseSQL("UPDATE Employees AS Emp\r\n" + //
//				" SET retired='Yes'\r\n" + //
//				" FROM Retirees AS Rt\r\n" + //
//				" WHERE Emp.EmpId = Rt.EmpId");
//		parseSQL("DROP TRIGGER EmployNameTrig FROM Sample.Employee");
//
//		parseSQL("CREATE TABLE Student_Trigger  \r\n " //
//				+ "(  Student_RollNo INT NOT NULL PRIMARY KEY,  \r\n" //
//				+ "Student_FirstName Varchar (100),  \r\n" //
//				+ "Student_EnglishMarks INT,  \r\n" + "Student_PhysicsMarks INT,   \r\n" //
//				+ "Student_ChemistryMarks INT,  \r\n" + "Student_MathsMarks INT,  \r\n" //
//				+ "Student_TotalMarks INT,  \r\n" + "Student_Percentage  )");
//
//		parseSQL("SELECT DISTINCT Age FROM Sample.Person\r\n" + "WHERE Age < ALL\r\n"
//				+ "   (SELECT Age FROM Sample.Employee)\r\n" + "ORDER BY Age");
//		parseSQL("SELECT DISTINCT State\r\6n" + "FROM Sample.USZipCode\r\n" + "WHERE Longitude < -93\r\n"
//		+ "  AND State != ALL\r\n" + "   (SELECT Home_State FROM Sample.Employee\r\n"
//		+ "  WHERE Title [ 'Manager' OR Title [ 'Director')\r\n" + "ORDER BY State");
//
//		parseSQL("SELECT Name,COUNT(Name) AS NameCount\r\n" + "FROM Sample.Person AS p\r\n"
//				+ "WHERE FOR SOME (Sample.Employee AS e)(e.Name=p.Name)\r\n" + "ORDER BY Name");
//		parseSQL("SELECT Name,Age,COUNT(Name) AS NameCount\r\n" + "FROM Sample.Person\r\n"
//				+ "WHERE FOR SOME (Sample.Person)(Age>65)\r\n" + "ORDER BY Age");
//
//		parseSQL("SELECT Name,DOB FROM Sample.Person \r\n" //
//				+ "GROUP BY DOB\r\n"
//				+ "HAVING DOB IN ({d '1951-02-02'},{d '1987-02-28'})");
//		parseSQL("SELECT Name,Age FROM \r\n" + "  (SELECT Name,Age FROM Sample.Person\r\n"
//				+ "   UNION SELECT Name,Age FROM Sample.Employee)\r\n"
//				+ "WHERE Age IN (SELECT TOP 5 Age FROM Sample.Employee WHERE Age>55 ORDER BY Age)");
//		
//		// ----------------------------------------------------
//		// ----- Not Working - No Tree
//		// ----------------------------------------------------
//		
//		parseSQL("ROLLBACK TO SAVEPOINT pointname");
//		parseSQL("SAVEPOINT SP1");
//		parseSQL("INSERT OR UPDATE SQLUser.CaveDwellers (Num,CaveCluster,Troglodyte) "
//				+ "VALUES (1,'Bedrock','Flintstone,Fred')");
//		parseSQL("CREATE TRIGGER EmployNameTrig AFTER INSERT,UPDATE,DELETE ON Sample.Employee\r\n"
//				+ "   LANGUAGE OBJECTSCRIPT\r\n"
//				+ "   {WRITE \"Employee old name:\",{Name*O},\" new name:\",{Name*N},\" \",{%%OPERATION},\" on \",{%%TABLENAME},!}");
//
//		parseSQL("ALTER TABLE schema.TableName RENAME NewTableName");
//		
//		parseSQL("CREATE USER apamb IDENTIFY BY password111");
//		parseSQL("DROP USER apamb");
//		parseSQL("ALTER USER apple IDENTIFY BY password");
//		parseSQL("CREATE ROLE Anji1");
//		parseSQL("GRANT role TO grantee");
//		
//		parseSQL("CREATE QUERY AgeQuery11(IN topnum INT DEFAULT 10)\r\n" + //
//		"BEGIN SELECT * FROM Sample.Person2;\r\n" + //
//		"END");
//		parseSQL("DROP QUERY AgeQuery11");
//		
//		parseSQL("CREATE INDEX CityIndex ON Sample.Employee(name)");
//		parseSQL("DROP INDEX Sample.Employee.CityIndex");
//		parseSQL("DROP INDEX CityIndex");
//		parseSQL("DROP INDEX CityIndex ON TABLE Sample.Employee");
//		
//		parseSQL("CREATE FUNCTION RandomLetter()\r\n" + "RETURNS INTEGER\r\n" + "PROCEDURE\r\n"
//		+ "LANGUAGE OBJECTSCRIPT\r\n" + "{\r\n" + ":Top\r\n" + " SET x=$RANDOM(90)\r\n"
//		+ " IF x<65 {GOTO Top}\r\n" + " ELSE {QUIT $CHAR(x)}\r\n" + "}");
//
//		parseSQL("CREATE FUNCTION hello (s CHAR(20))\r\n" + "RETURNS CHAR(50) DETERMINISTIC\r\n"
//		+ "       RETURN CONCAT('Hello, ',s,'!')");
//
//		parseSQL("CREATE AGGREGATE Sample.SumAddSub(arg NUMERIC(4,1)) \r\n" + "   ITERATE WITH Sample.AddSub");
//		parseSQL("CREATE OR REPLACE AGGREGATE Sample.SumAddSub(arg NUMERIC(4,1))\r\n"
//				+ "   ITERATE WITH Sample.AddSub\r\n" + "   FINALIZE WITH Sample.NoNeg");
//		parseSQL("DROP AGGREGATE Sample.SumAddSub");
//
//		parseSQL("DELETE TempEmployees");		
//		
//		parseSQL("ALTER VIEW MassFolks (vMassAbbrev,vCity) AS\r\n"
//				+ "     SELECT Home_State,Home_City FROM Sample.Person WHERE Home_State='MA'");
//
//		parseSQL("CREATE FOREIGN TABLE Sample.Person (\r\n" + "   FileColumnOne VARCHAR(10),\r\n"
//				+ "   FileColumnTwo VARCHAR(20)\r\n"
//				+ ") SERVER Sample.HospitalDir FILE person.csv COLUMNS (FileColumnTwo VARCHAR(20), FileColumnOne VARCHAR(10))");
//
//		parseSQL("DROP FOREIGN TABLE Example.MyTable RESTRICT");
//
//		parseSQL("DROP FUNCTION RandomLetter");
//		
//		parseSQL("CREATE PROCEDURE UpdateSalary ( IN SSN VARCHAR(11), IN Salary INTEGER )\r\n"
//		+ "   FOR Sample.Employee\r\n" + "   BEGIN\r\n"
//		+ "     UPDATE Sample.Employee SET Salary = :Salary WHERE SSN = :SSN;\r\n" + "   END");
//
//		parseSQL("DROP PROCEDURE RandomLetterSP");
//		
//		parseSQL("LOAD DATA FROM FILE 'C://mydata/countries.csv'\r\n" + "INTO Sample.Countries");

//		parseSQL("SELECT DISTINCT BY (Home_State,Age) Name,Age FROM Sample.Person");
//		parseSQL("SELECT DISTINCT BY (ROUND(Age,-1)) Age,AVG(Age) AS AvgAge FROM Sample.Person\r\n");
//		parseSQL("SELECT DISTINCT BY (AVG(Age)) Name,Age,AVG(Age) FROM Sample.Person");

	}

	public static void parseSQL(String sql) throws Exception {

		System.out.println("--------------------------------------------");
		System.out.println("sql : " + sql);
		System.out.println("--------------------------------------------");

		ParseRunner<?> runner = ParseUtils.createParseRunner(false, PegjsMySqlParser.class);
//		ParseRunner<?> runner = ParseUtils.createParseRunner(true, PegjsMySqlParser.class);

		ParsingResult<?> result = runner.run(sql);

		if (result.parseErrors.size() == 0) {

			System.out.println("tree : ");

			printTree(result);

			List<Map<String, Object>> verbObjectMapList = prepareVerbObjectMap(result);
			System.out.println("verbObjectMapList : " + verbObjectMapList);

			verbObjectMapList.forEach(PegjsMySqlParserTest::cleanVerbs);
			System.out.println("verbObjectMapList-cleaned : " + verbObjectMapList);

		} else {
			throw new RuntimeException("not matched : " + sql);
		}

		String rootNodeValue = ParseTreeUtils.getNodeText(result.parseTreeRoot, result.inputBuffer).trim();

		if (rootNodeValue.isEmpty()) {
			throw new RuntimeException("no tree : " + sql);
		}

		if (!rootNodeValue.isEmpty() && !sql.trim().equals(rootNodeValue)) {
			throw new RuntimeException("half tree : " + sql);
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