// Generated from C:/Users/wort2/OneDrive/¹®¼­/GitHub/antlrStudy/grammar\SQL.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCOL=1, DOT=2, OPEN_PAR=3, CLOSE_PAR=4, COMMA=5, ASSIGN=6, STAR=7, PLUS=8, 
		MINUS=9, TILDE=10, PIPE2=11, DIV=12, MOD=13, LT2=14, GT2=15, AMP=16, PIPE=17, 
		LT=18, LT_EQ=19, GT=20, GT_EQ=21, EQ=22, NOT_EQ1=23, NOT_EQ2=24, K_AS=25, 
		K_FROM=26, K_INSERT=27, K_ISNULL=28, K_NOT=29, K_NOTNULL=30, K_NULL=31, 
		K_SELECT=32, K_TABLE=33, K_VALUES=34, IDENTIFIER=35, NUMERIC_LITERAL=36, 
		BIND_PARAMETER=37, STRING_LITERAL=38, BLOB_LITERAL=39, WS=40;
	public static final int
		RULE_parse = 0, RULE_insert_stmt = 1, RULE_select_stmt = 2, RULE_table = 3, 
		RULE_result_column = 4, RULE_expr = 5, RULE_literal_value = 6, RULE_unary_operator = 7, 
		RULE_keyword = 8, RULE_table_name = 9, RULE_column_name = 10, RULE_any_name = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "insert_stmt", "select_stmt", "table", "result_column", "expr", 
			"literal_value", "unary_operator", "keyword", "table_name", "column_name", 
			"any_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "')'", "','", "'='", "'*'", "'+'", "'-'", 
			"'~'", "'||'", "'/'", "'%'", "'<<'", "'>>'", "'&'", "'|'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'<>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SCOL", "DOT", "OPEN_PAR", "CLOSE_PAR", "COMMA", "ASSIGN", "STAR", 
			"PLUS", "MINUS", "TILDE", "PIPE2", "DIV", "MOD", "LT2", "GT2", "AMP", 
			"PIPE", "LT", "LT_EQ", "GT", "GT_EQ", "EQ", "NOT_EQ1", "NOT_EQ2", "K_AS", 
			"K_FROM", "K_INSERT", "K_ISNULL", "K_NOT", "K_NOTNULL", "K_NULL", "K_SELECT", 
			"K_TABLE", "K_VALUES", "IDENTIFIER", "NUMERIC_LITERAL", "BIND_PARAMETER", 
			"STRING_LITERAL", "BLOB_LITERAL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public List<Insert_stmtContext> insert_stmt() {
			return getRuleContexts(Insert_stmtContext.class);
		}
		public Insert_stmtContext insert_stmt(int i) {
			return getRuleContext(Insert_stmtContext.class,i);
		}
		public List<Select_stmtContext> select_stmt() {
			return getRuleContexts(Select_stmtContext.class);
		}
		public Select_stmtContext select_stmt(int i) {
			return getRuleContext(Select_stmtContext.class,i);
		}
		public List<TerminalNode> SCOL() { return getTokens(SQLParser.SCOL); }
		public TerminalNode SCOL(int i) {
			return getToken(SQLParser.SCOL, i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_INSERT:
				{
				setState(24);
				insert_stmt();
				}
				break;
			case K_SELECT:
				{
				setState(25);
				select_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(29); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(28);
						match(SCOL);
						}
						}
						setState(31); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SCOL );
					setState(35);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case K_INSERT:
						{
						setState(33);
						insert_stmt();
						}
						break;
					case K_SELECT:
						{
						setState(34);
						select_stmt();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SCOL) {
				{
				{
				setState(42);
				match(SCOL);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_stmtContext extends ParserRuleContext {
		public TerminalNode K_INSERT() { return getToken(SQLParser.K_INSERT, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode K_VALUES() { return getToken(SQLParser.K_VALUES, 0); }
		public List<TerminalNode> OPEN_PAR() { return getTokens(SQLParser.OPEN_PAR); }
		public TerminalNode OPEN_PAR(int i) {
			return getToken(SQLParser.OPEN_PAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> CLOSE_PAR() { return getTokens(SQLParser.CLOSE_PAR); }
		public TerminalNode CLOSE_PAR(int i) {
			return getToken(SQLParser.CLOSE_PAR, i);
		}
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Insert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterInsert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitInsert_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitInsert_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_stmtContext insert_stmt() throws RecognitionException {
		Insert_stmtContext _localctx = new Insert_stmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_insert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(K_INSERT);
			setState(49);
			table_name();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_PAR) {
				{
				setState(50);
				match(OPEN_PAR);
				setState(51);
				column_name();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(52);
					match(COMMA);
					setState(53);
					column_name();
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(59);
				match(CLOSE_PAR);
				}
			}

			{
			setState(63);
			match(K_VALUES);
			setState(64);
			match(OPEN_PAR);
			setState(65);
			expr(0);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(66);
				match(COMMA);
				setState(67);
				expr(0);
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(CLOSE_PAR);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(74);
				match(COMMA);
				setState(75);
				match(OPEN_PAR);
				setState(76);
				expr(0);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(77);
					match(COMMA);
					setState(78);
					expr(0);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(CLOSE_PAR);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_stmtContext extends ParserRuleContext {
		public List<TerminalNode> K_SELECT() { return getTokens(SQLParser.K_SELECT); }
		public TerminalNode K_SELECT(int i) {
			return getToken(SQLParser.K_SELECT, i);
		}
		public List<Result_columnContext> result_column() {
			return getRuleContexts(Result_columnContext.class);
		}
		public Result_columnContext result_column(int i) {
			return getRuleContext(Result_columnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List<TerminalNode> K_FROM() { return getTokens(SQLParser.K_FROM); }
		public TerminalNode K_FROM(int i) {
			return getToken(SQLParser.K_FROM, i);
		}
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public Select_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterSelect_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitSelect_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSelect_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_stmtContext select_stmt() throws RecognitionException {
		Select_stmtContext _localctx = new Select_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(K_SELECT);
			setState(92);
			result_column();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				result_column();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_FROM) {
				{
				setState(100);
				match(K_FROM);
				{
				setState(101);
				table();
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(102);
					match(COMMA);
					setState(103);
					table();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
			}

			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_SELECT) {
				{
				{
				setState(111);
				match(K_SELECT);
				setState(112);
				result_column();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(113);
					match(COMMA);
					setState(114);
					result_column();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_FROM) {
					{
					setState(120);
					match(K_FROM);
					{
					setState(121);
					table();
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(122);
						match(COMMA);
						setState(123);
						table();
						}
						}
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
				}

				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			table_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Result_columnContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Result_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterResult_column(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitResult_column(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitResult_column(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Result_columnContext result_column() throws RecognitionException {
		Result_columnContext _localctx = new Result_columnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_result_column);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(STAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				table_name();
				setState(140);
				match(DOT);
				setState(141);
				match(STAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public TerminalNode BIND_PARAMETER() { return getToken(SQLParser.BIND_PARAMETER, 0); }
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public TerminalNode PIPE2() { return getToken(SQLParser.PIPE2, 0); }
		public TerminalNode STAR() { return getToken(SQLParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(SQLParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SQLParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public TerminalNode LT2() { return getToken(SQLParser.LT2, 0); }
		public TerminalNode GT2() { return getToken(SQLParser.GT2, 0); }
		public TerminalNode AMP() { return getToken(SQLParser.AMP, 0); }
		public TerminalNode PIPE() { return getToken(SQLParser.PIPE, 0); }
		public TerminalNode LT() { return getToken(SQLParser.LT, 0); }
		public TerminalNode LT_EQ() { return getToken(SQLParser.LT_EQ, 0); }
		public TerminalNode GT() { return getToken(SQLParser.GT, 0); }
		public TerminalNode GT_EQ() { return getToken(SQLParser.GT_EQ, 0); }
		public TerminalNode K_ISNULL() { return getToken(SQLParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SQLParser.K_NOTNULL, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(147);
				literal_value();
				}
				break;
			case 2:
				{
				setState(148);
				match(BIND_PARAMETER);
				}
				break;
			case 3:
				{
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(149);
					table_name();
					setState(150);
					match(DOT);
					}
					break;
				}
				setState(154);
				column_name();
				}
				break;
			case 4:
				{
				setState(155);
				unary_operator();
				setState(156);
				expr(8);
				}
				break;
			case 5:
				{
				setState(158);
				match(OPEN_PAR);
				setState(159);
				expr(0);
				setState(160);
				match(CLOSE_PAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(165);
						match(PIPE2);
						setState(166);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(168);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAR) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(171);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(172);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(174);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT2) | (1L << GT2) | (1L << AMP) | (1L << PIPE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(175);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(177);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LT_EQ) | (1L << GT) | (1L << GT_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(184);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case K_ISNULL:
							{
							setState(180);
							match(K_ISNULL);
							}
							break;
						case K_NOTNULL:
							{
							setState(181);
							match(K_NOTNULL);
							}
							break;
						case K_NOT:
							{
							setState(182);
							match(K_NOT);
							setState(183);
							match(K_NULL);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public TerminalNode BLOB_LITERAL() { return getToken(SQLParser.BLOB_LITERAL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitLiteral_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitLiteral_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_literal_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_NULL) | (1L << NUMERIC_LITERAL) | (1L << STRING_LITERAL) | (1L << BLOB_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(SQLParser.TILDE, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << TILDE) | (1L << K_NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_AS() { return getToken(SQLParser.K_AS, 0); }
		public TerminalNode K_FROM() { return getToken(SQLParser.K_FROM, 0); }
		public TerminalNode K_INSERT() { return getToken(SQLParser.K_INSERT, 0); }
		public TerminalNode K_ISNULL() { return getToken(SQLParser.K_ISNULL, 0); }
		public TerminalNode K_NOT() { return getToken(SQLParser.K_NOT, 0); }
		public TerminalNode K_NOTNULL() { return getToken(SQLParser.K_NOTNULL, 0); }
		public TerminalNode K_NULL() { return getToken(SQLParser.K_NULL, 0); }
		public TerminalNode K_SELECT() { return getToken(SQLParser.K_SELECT, 0); }
		public TerminalNode K_TABLE() { return getToken(SQLParser.K_TABLE, 0); }
		public TerminalNode K_VALUES() { return getToken(SQLParser.K_VALUES, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_AS) | (1L << K_FROM) | (1L << K_INSERT) | (1L << K_ISNULL) | (1L << K_NOT) | (1L << K_NOTNULL) | (1L << K_NULL) | (1L << K_SELECT) | (1L << K_TABLE) | (1L << K_VALUES))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColumn_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumn_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			any_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(SQLParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(SQLParser.STRING_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(SQLParser.NUMERIC_LITERAL, 0); }
		public TerminalNode OPEN_PAR() { return getToken(SQLParser.OPEN_PAR, 0); }
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public TerminalNode CLOSE_PAR() { return getToken(SQLParser.CLOSE_PAR, 0); }
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitAny_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAny_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_any_name);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(IDENTIFIER);
				}
				break;
			case K_AS:
			case K_FROM:
			case K_INSERT:
			case K_ISNULL:
			case K_NOT:
			case K_NOTNULL:
			case K_NULL:
			case K_SELECT:
			case K_TABLE:
			case K_VALUES:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				keyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				match(STRING_LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(NUMERIC_LITERAL);
				}
				break;
			case OPEN_PAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				match(OPEN_PAR);
				setState(206);
				any_name();
				setState(207);
				match(CLOSE_PAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\5\2\35\n\2\3\2\6\2 \n\2\r\2\16\2!\3\2\3\2"+
		"\5\2&\n\2\7\2(\n\2\f\2\16\2+\13\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\5\3@\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3R\n\3\f"+
		"\3\16\3U\13\3\3\3\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\4\3\4\3\4\3\4\7\4b\n"+
		"\4\f\4\16\4e\13\4\3\4\3\4\3\4\3\4\7\4k\n\4\f\4\16\4n\13\4\5\4p\n\4\3\4"+
		"\3\4\3\4\3\4\7\4v\n\4\f\4\16\4y\13\4\3\4\3\4\3\4\3\4\7\4\177\n\4\f\4\16"+
		"\4\u0082\13\4\5\4\u0084\n\4\7\4\u0086\n\4\f\4\16\4\u0089\13\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0093\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009b"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a5\n\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00bb"+
		"\n\7\7\7\u00bd\n\7\f\7\16\7\u00c0\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d4\n\r\3\r\2\3\f\16"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\2\t\4\2\t\t\16\17\3\2\n\13\3\2\20\23\3"+
		"\2\24\27\5\2!!&&()\4\2\n\f\37\37\3\2\33$\2\u00ed\2\34\3\2\2\2\4\62\3\2"+
		"\2\2\6]\3\2\2\2\b\u008a\3\2\2\2\n\u0092\3\2\2\2\f\u00a4\3\2\2\2\16\u00c1"+
		"\3\2\2\2\20\u00c3\3\2\2\2\22\u00c5\3\2\2\2\24\u00c7\3\2\2\2\26\u00c9\3"+
		"\2\2\2\30\u00d3\3\2\2\2\32\35\5\4\3\2\33\35\5\6\4\2\34\32\3\2\2\2\34\33"+
		"\3\2\2\2\35)\3\2\2\2\36 \7\3\2\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!"+
		"\"\3\2\2\2\"%\3\2\2\2#&\5\4\3\2$&\5\6\4\2%#\3\2\2\2%$\3\2\2\2&(\3\2\2"+
		"\2\'\37\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*/\3\2\2\2+)\3\2\2\2,.\7"+
		"\3\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\3\3\2\2\2\61/\3"+
		"\2\2\2\62\63\7\35\2\2\63?\5\24\13\2\64\65\7\5\2\2\65:\5\26\f\2\66\67\7"+
		"\7\2\2\679\5\26\f\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2"+
		"\2<:\3\2\2\2=>\7\6\2\2>@\3\2\2\2?\64\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7$"+
		"\2\2BC\7\5\2\2CH\5\f\7\2DE\7\7\2\2EG\5\f\7\2FD\3\2\2\2GJ\3\2\2\2HF\3\2"+
		"\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KZ\7\6\2\2LM\7\7\2\2MN\7\5\2\2NS\5\f"+
		"\7\2OP\7\7\2\2PR\5\f\7\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2"+
		"\2\2US\3\2\2\2VW\7\6\2\2WY\3\2\2\2XL\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3"+
		"\2\2\2[\5\3\2\2\2\\Z\3\2\2\2]^\7\"\2\2^c\5\n\6\2_`\7\7\2\2`b\5\n\6\2a"+
		"_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2do\3\2\2\2ec\3\2\2\2fg\7\34\2\2"+
		"gl\5\b\5\2hi\7\7\2\2ik\5\b\5\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2"+
		"mp\3\2\2\2nl\3\2\2\2of\3\2\2\2op\3\2\2\2p\u0087\3\2\2\2qr\7\"\2\2rw\5"+
		"\n\6\2st\7\7\2\2tv\5\n\6\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\u0083"+
		"\3\2\2\2yw\3\2\2\2z{\7\34\2\2{\u0080\5\b\5\2|}\7\7\2\2}\177\5\b\5\2~|"+
		"\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083z\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085q\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\7\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\5"+
		"\24\13\2\u008b\t\3\2\2\2\u008c\u0093\7\t\2\2\u008d\u008e\5\24\13\2\u008e"+
		"\u008f\7\4\2\2\u008f\u0090\7\t\2\2\u0090\u0093\3\2\2\2\u0091\u0093\5\f"+
		"\7\2\u0092\u008c\3\2\2\2\u0092\u008d\3\2\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\13\3\2\2\2\u0094\u0095\b\7\1\2\u0095\u00a5\5\16\b\2\u0096\u00a5\7\'\2"+
		"\2\u0097\u0098\5\24\13\2\u0098\u0099\7\4\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0097\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a5\5\26"+
		"\f\2\u009d\u009e\5\20\t\2\u009e\u009f\5\f\7\n\u009f\u00a5\3\2\2\2\u00a0"+
		"\u00a1\7\5\2\2\u00a1\u00a2\5\f\7\2\u00a2\u00a3\7\6\2\2\u00a3\u00a5\3\2"+
		"\2\2\u00a4\u0094\3\2\2\2\u00a4\u0096\3\2\2\2\u00a4\u009a\3\2\2\2\u00a4"+
		"\u009d\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a5\u00be\3\2\2\2\u00a6\u00a7\f\t"+
		"\2\2\u00a7\u00a8\7\r\2\2\u00a8\u00bd\5\f\7\n\u00a9\u00aa\f\b\2\2\u00aa"+
		"\u00ab\t\2\2\2\u00ab\u00bd\5\f\7\t\u00ac\u00ad\f\7\2\2\u00ad\u00ae\t\3"+
		"\2\2\u00ae\u00bd\5\f\7\b\u00af\u00b0\f\6\2\2\u00b0\u00b1\t\4\2\2\u00b1"+
		"\u00bd\5\f\7\7\u00b2\u00b3\f\5\2\2\u00b3\u00b4\t\5\2\2\u00b4\u00bd\5\f"+
		"\7\6\u00b5\u00ba\f\3\2\2\u00b6\u00bb\7\36\2\2\u00b7\u00bb\7 \2\2\u00b8"+
		"\u00b9\7\37\2\2\u00b9\u00bb\7!\2\2\u00ba\u00b6\3\2\2\2\u00ba\u00b7\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00a6\3\2\2\2\u00bc"+
		"\u00a9\3\2\2\2\u00bc\u00ac\3\2\2\2\u00bc\u00af\3\2\2\2\u00bc\u00b2\3\2"+
		"\2\2\u00bc\u00b5\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\r\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\t\6\2\2"+
		"\u00c2\17\3\2\2\2\u00c3\u00c4\t\7\2\2\u00c4\21\3\2\2\2\u00c5\u00c6\t\b"+
		"\2\2\u00c6\23\3\2\2\2\u00c7\u00c8\5\30\r\2\u00c8\25\3\2\2\2\u00c9\u00ca"+
		"\5\30\r\2\u00ca\27\3\2\2\2\u00cb\u00d4\7%\2\2\u00cc\u00d4\5\22\n\2\u00cd"+
		"\u00d4\7(\2\2\u00ce\u00d4\7&\2\2\u00cf\u00d0\7\5\2\2\u00d0\u00d1\5\30"+
		"\r\2\u00d1\u00d2\7\6\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3"+
		"\u00cc\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00cf\3\2"+
		"\2\2\u00d4\31\3\2\2\2\32\34!%)/:?HSZclow\u0080\u0083\u0087\u0092\u009a"+
		"\u00a4\u00ba\u00bc\u00be\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}