package org.parboiled.peg;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.parboiled.Action;
import org.parboiled.Node;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.support.ParsingResult;
import org.parboiled.util.ParseUtils;

@BuildParseTree
public class PegjsMySqlParser extends BasePegjsParser {

	protected static Set<String> KEYWORDS = new HashSet<>();
	static {

		KEYWORDS.add("ALTER");
		KEYWORDS.add("ALL");
		KEYWORDS.add("ADD");
		KEYWORDS.add("AND");
		KEYWORDS.add("AS");
		KEYWORDS.add("ASC");
		KEYWORDS.add("ANALYZE");
		KEYWORDS.add("ACCESSIBLE");

		KEYWORDS.add("BEFORE");
		KEYWORDS.add("BETWEEN");
		KEYWORDS.add("BIGINT");
		KEYWORDS.add("BLOB");
		KEYWORDS.add("BOTH");
		KEYWORDS.add("BY");
		KEYWORDS.add("BOOLEAN");

		KEYWORDS.add("CALL");
		KEYWORDS.add("CASCADE");
		KEYWORDS.add("CASE");
		KEYWORDS.add("CHAR");
		KEYWORDS.add("CHECK");
		KEYWORDS.add("COLLATE");
		KEYWORDS.add("COLUMN");
		KEYWORDS.add("CONDITION");
		KEYWORDS.add("CONSTRAINT");
		KEYWORDS.add("CONTINUE");
		KEYWORDS.add("CONVERT");
		KEYWORDS.add("CREATE");
		KEYWORDS.add("CROSS");
		KEYWORDS.add("CURRENT_DATE");
		KEYWORDS.add("CURRENT_TIME");
		KEYWORDS.add("CURRENT_TIMESTAMP");
		KEYWORDS.add("CURRENT_USER");
		KEYWORDS.add("CURSOR");

		KEYWORDS.add("DATABASE");
		KEYWORDS.add("DATABASES");
		KEYWORDS.add("DAY_HOUR");
		KEYWORDS.add("DAY_MICROSECOND");
		KEYWORDS.add("DAY_MINUTE");
		KEYWORDS.add("DAY_SECOND");
		KEYWORDS.add("DEC");
		KEYWORDS.add("DECIMAL");
		KEYWORDS.add("DECLARE");
		KEYWORDS.add("DEFAULT");
		KEYWORDS.add("DELAYED");
		KEYWORDS.add("DELETE");
		KEYWORDS.add("DESC");
		KEYWORDS.add("DESCRIBE");
		KEYWORDS.add("DETERMINISTIC");
		KEYWORDS.add("DISTINCT");
		KEYWORDS.add("DISTINCTROW");
		KEYWORDS.add("DIV");
		KEYWORDS.add("DROP");
		KEYWORDS.add("DOUBLE");
		KEYWORDS.add("DUAL");

		KEYWORDS.add("ELSE");
		KEYWORDS.add("EACH");
		KEYWORDS.add("ELSEIF");
		KEYWORDS.add("ENCLOSED");
		KEYWORDS.add("ESCAPED");
		KEYWORDS.add("EXCEPT");
		KEYWORDS.add("EXISTS");
		KEYWORDS.add("EXIT");
		KEYWORDS.add("EXPLAIN");

		KEYWORDS.add("FALSE");
		KEYWORDS.add("FULL");
		KEYWORDS.add("FROM");
		KEYWORDS.add("FETCH");
		KEYWORDS.add("FLOAT");
		KEYWORDS.add("FLOAT4");
		KEYWORDS.add("FLOAT8");
		KEYWORDS.add("FOR");
		KEYWORDS.add("FORCE");
		KEYWORDS.add("FOREIGN");
		KEYWORDS.add("FULLTEXT");
		KEYWORDS.add("FUNCTION");

		KEYWORDS.add("GENERATED");
		KEYWORDS.add("GET");
		KEYWORDS.add("GO");
		KEYWORDS.add("GRANT");
		KEYWORDS.add("GROUP");
		KEYWORDS.add("GROUPING");
		KEYWORDS.add("GROUPS");

		KEYWORDS.add("HAVING");
		KEYWORDS.add("HIGH_PRIORITY");
		KEYWORDS.add("HOUR_MICROSECOND");
		KEYWORDS.add("HOUR_MINUTE");
		KEYWORDS.add("HOUR_SECOND");

		KEYWORDS.add("IF");
		KEYWORDS.add("IGNORE");
		KEYWORDS.add("IN");
		KEYWORDS.add("INNER");
		KEYWORDS.add("INFILE");
		KEYWORDS.add("INOUT");
		KEYWORDS.add("INSENSITIVE");
		KEYWORDS.add("INSERT");
		KEYWORDS.add("INTERSECT");
		KEYWORDS.add("INT");
		KEYWORDS.add("INT1");
		KEYWORDS.add("INT2");
		KEYWORDS.add("INT3");
		KEYWORDS.add("INT4");
		KEYWORDS.add("INT8");
		KEYWORDS.add("INTEGER");
		KEYWORDS.add("INTERVAL");
		KEYWORDS.add("INTO");
		KEYWORDS.add("IO_AFTER_GTIDS");
		KEYWORDS.add("IO_BEFORE_GTIDS");
		KEYWORDS.add("IS");
		KEYWORDS.add("ITERATE");

		KEYWORDS.add("JOIN");
		KEYWORDS.add("JSON_TABLE");

		KEYWORDS.add("KEY");
		KEYWORDS.add("KEYS");
		KEYWORDS.add("KILL");

		KEYWORDS.add("LAG");
		KEYWORDS.add("LAST_VALUE");
		KEYWORDS.add("LATERAL");
		KEYWORDS.add("LEAD");
		KEYWORDS.add("LEADING");
		KEYWORDS.add("LEAVE");
		KEYWORDS.add("LEFT");
		KEYWORDS.add("LIKE");
		KEYWORDS.add("LIMIT");
		KEYWORDS.add("LINEAR");
		KEYWORDS.add("LINES");
		KEYWORDS.add("LOAD");
		KEYWORDS.add("LOCALTIME");
		KEYWORDS.add("LOCALTIMESTAMP");
		KEYWORDS.add("LOCK");
		KEYWORDS.add("LONG");
		KEYWORDS.add("LONGBLOB");
		KEYWORDS.add("LONGTEXT");
		KEYWORDS.add("LOOP");
		KEYWORDS.add("LOW_PRIORITY");

		KEYWORDS.add("MASTER_BIND");
		KEYWORDS.add("MATCH");
		KEYWORDS.add("MAXVALUE");
		KEYWORDS.add("MEDIUMBLOB");
		KEYWORDS.add("MEDIUMINT");
		KEYWORDS.add("MEDIUMTEXT");
		KEYWORDS.add("MIDDLEINT");
		KEYWORDS.add("MINUTE_MICROSECOND");
		KEYWORDS.add("MINUTE_SECOND");
		KEYWORDS.add("MINUS");
		KEYWORDS.add("MOD");
		KEYWORDS.add("MODIFIES");

		KEYWORDS.add("NATURAL");
		KEYWORDS.add("NOT");
		KEYWORDS.add("NO_WRITE_TO_BINLOG");
		KEYWORDS.add("NTH_VALUE");
		KEYWORDS.add("NTILE");
		KEYWORDS.add("NULL");
		KEYWORDS.add("NUMERIC");

		KEYWORDS.add("OF");
		KEYWORDS.add("ON");
		KEYWORDS.add("OPTIMIZE");
		KEYWORDS.add("OPTIMIZER_COSTS");
		KEYWORDS.add("OPTION");
		KEYWORDS.add("OPTIONALLY");
		KEYWORDS.add("OR");
		KEYWORDS.add("ORDER");
		KEYWORDS.add("OUT");
		KEYWORDS.add("OUTER");
		KEYWORDS.add("OUTFILE");
		KEYWORDS.add("OVER");

		KEYWORDS.add("PARTITION");
		KEYWORDS.add("PERCENT_RANK");
		KEYWORDS.add("PRECISION");
		KEYWORDS.add("PRIMARY");
		KEYWORDS.add("PROCEDURE");
		KEYWORDS.add("PURGE");

		KEYWORDS.add("RANGE");
		KEYWORDS.add("RANK");
		KEYWORDS.add("READ");
		KEYWORDS.add("READS");
		KEYWORDS.add("READ_WRITE");
		KEYWORDS.add("REAL");
		KEYWORDS.add("RECURSIVE");
		KEYWORDS.add("REFERENCES");
		KEYWORDS.add("REGEXP");
		KEYWORDS.add("RELEASE");
		KEYWORDS.add("RENAME");
		KEYWORDS.add("REPEAT");
		KEYWORDS.add("REPLACE");
		KEYWORDS.add("REQUIRE");
		KEYWORDS.add("RESIGNAL");
		KEYWORDS.add("RESTRICT");
		KEYWORDS.add("RETURN");
		KEYWORDS.add("REVOKE");
		KEYWORDS.add("RIGHT");
		KEYWORDS.add("RLIKE");
		KEYWORDS.add("ROW");
		KEYWORDS.add("ROWS");
		KEYWORDS.add("ROW_NUMBER");

		KEYWORDS.add("SCHEMA");
		KEYWORDS.add("SCHEMAS");
		KEYWORDS.add("SELECT");
		KEYWORDS.add("SENSITIVE");
		KEYWORDS.add("SEPARATOR");
		KEYWORDS.add("SET");
		KEYWORDS.add("SHOW");
		KEYWORDS.add("SIGNAL");
		KEYWORDS.add("SMALLINT");
		KEYWORDS.add("SPATIAL");
		KEYWORDS.add("SPECIFIC");
		KEYWORDS.add("SQL");
		KEYWORDS.add("SQLEXCEPTION");
		KEYWORDS.add("SQLSTATE");
		KEYWORDS.add("SQLWARNING");
		KEYWORDS.add("SQL_BIG_RESULT");
		KEYWORDS.add("SQL_CALC_FOUND_ROWS");
		KEYWORDS.add("SQL_SMALL_RESULT");
		KEYWORDS.add("SSL");
		KEYWORDS.add("STARTING");
		KEYWORDS.add("STORED");
		KEYWORDS.add("STRAIGHT_JOIN");
		KEYWORDS.add("SYSTEM");

		KEYWORDS.add("TABLE");
		KEYWORDS.add("TERMINATED");
		KEYWORDS.add("THEN");
		KEYWORDS.add("TINYBLOB");
		KEYWORDS.add("TINYINT");
		KEYWORDS.add("TINYTEXT");
		KEYWORDS.add("TO");
		KEYWORDS.add("TRAILING");
		KEYWORDS.add("TRIGGER");
		KEYWORDS.add("TRUE");

		KEYWORDS.add("UNION");
		KEYWORDS.add("UNIQUE");
		KEYWORDS.add("UNLOCK");
		KEYWORDS.add("UNSIGNED");
		KEYWORDS.add("UPDATE");
		KEYWORDS.add("USAGE");
		KEYWORDS.add("USE");
		KEYWORDS.add("USING");
		KEYWORDS.add("UTC_DATE");
		KEYWORDS.add("UTC_TIME");
		KEYWORDS.add("UTC_TIMESTAMP");

		KEYWORDS.add("VALUES");
		KEYWORDS.add("VARBINARY");
		KEYWORDS.add("VARCHAR");
		KEYWORDS.add("VARCHARACTER");
		KEYWORDS.add("VARYING");
		KEYWORDS.add("VIRTUAL");

		KEYWORDS.add("WHEN");
		KEYWORDS.add("WHERE");
		KEYWORDS.add("WHILE");
		KEYWORDS.add("WINDOW");
		KEYWORDS.add("WITH");
		KEYWORDS.add("WRITE");

		KEYWORDS.add("XOR");

		KEYWORDS.add("YEAR_MONTH");

		KEYWORDS.add("ZEROFILL");
	}

	private static Map<String, String> VERB_LABELS_MAP = new HashMap<>();
	static {
	}

	private static List<String> OBJECT_LABELS = new LinkedList<>();
	static {
		OBJECT_LABELS.add("table_name");
	}

	public static Map<String, String> getVerbLabels() {
		return Collections.unmodifiableMap(VERB_LABELS_MAP);
	}

	public static List<String> getObjectLabels() {
		return Collections.unmodifiableList(OBJECT_LABELS);
	}

	private static List<String> SKIP_LABELS = new LinkedList<>();
	static {

		SKIP_LABELS.add("crud_stmt");
		SKIP_LABELS.add("union_stmt");
		SKIP_LABELS.add("select_stmt");

		SKIP_LABELS.add("STAR");
	}

	private static List<String> SUPRESS_LABELS = new LinkedList<>();
	static {
		SUPRESS_LABELS.add("__");
		SUPRESS_LABELS.add("___");
		SUPRESS_LABELS.add("ident_start");
		SUPRESS_LABELS.add("ident_part");
		SUPRESS_LABELS.add("column_part");
		SUPRESS_LABELS.add("digit");
	}

	private static List<String> SUPRESS_SUB_LABELS = new LinkedList<>();
	static {

		SUPRESS_SUB_LABELS.add("literal_string");
		SUPRESS_SUB_LABELS.add("single_quoted_ident");
		SUPRESS_SUB_LABELS.add("backticks_quoted_ident");
		SUPRESS_SUB_LABELS.add("double_quoted_ident");
		SUPRESS_SUB_LABELS.add("table_name");
		SUPRESS_SUB_LABELS.add("column_name");
	}

	private static Rule startRule;

	@Override
	public Rule start() {
		if (startRule == null) {
			String pegjs = ParseUtils.read(PegjsMySqlParser.class.getClassLoader().getResource("mysql.pegjs"));
			ParsingResult<?> result = ParseUtils.parse(pegjs, PegPegjsParser.class, false);
			startRule = start("start", result);
		}
		return startRule;
	}

	@Override
	protected Rule activateRule(String label, Rule rule) {
		if ("ident_name".equals(label) || "column_name".equals(label)) {
			rule = Sequence(rule, (Action<?>) context -> !KEYWORDS.contains(context.getMatch().toUpperCase()));
		}
		return rule;
	}

	protected Rule parseRule(ParsingResult<?> result, Node<?> parent) {
		Rule rule = super.parseRule(result, parent);

		if (rule != null) {
			String value = result.inputBuffer.extract(parent.getStartIndex(), parent.getEndIndex());
			if (SUPRESS_LABELS.contains(value)) {
				rule.suppressNode();
			} else if (value.startsWith("\"") || value.startsWith("'") || SUPRESS_SUB_LABELS.contains(value)) {
				rule.suppressSubnodes();
			} else if (SKIP_LABELS.contains(value)) {
				rule.skipNode();
			}
		}

		return rule;
	}

	public static ParsingResult<?> parse(String script) throws Exception {
		System.out.println("script : " + script);
		ParsingResult<?> result = ParseUtils.parse(script, PegjsMySqlParser.class, false);
//		ParsingResult<?> result = ParseUtils.parse(script, PegjsMySqlParser.class, true);
		ParseUtils.printTree(result);
		return result;
	}

	public static void main(String[] args) throws Exception {

		parse("SELECT * FROM employee");

	}

}