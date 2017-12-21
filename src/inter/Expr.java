package inter;

import lexer.*; import symbols.*;

public class Expr extends Node {
	public Token op;
	public Type type;

	Expr(Token tok, Type p) { op = tok; type = p; }
	
	/**
	 * ����һ���������Գ�Ϊһ������ַָ����Ҳ�������һ�����ʽE=E1+E2
	 * ����gen����һ����x1+x2������x1��x2�ֱ��Ǵ��E1��E2ֵ�ĵ�ַ�����
	 * ���������һ����ַ���Ϳ��Է���thisֵ��Expr������ͨ��������ʵ��gen
	 * @return
	 */
	public Expr gen() { return this; }
	
	/**
	 * ��һ�����ʽ�����Ϊһ����һ�ĵ�ַ��Ҳ����˵��������һ����������ʶ����
	 * ����һ����ʱ���֡�����һ�����ʽE������reduce����һ�����E��ֵ����
	 * ʱ����t��������������һ����ַ����ôthis��Ȼ����ȷ�ķ���ֵ��
	 * @return
	 */
	public Expr reduce() { return this; }

	public void jumping(int t, int f) { emitjumps(toString(), t, f); }

	/**
	 * �������ʽ������ת����
	 * @param test
	 * @param t tureʱ���ڵı��
	 * @param f falseʱ���ڵı��
	 */
	public void emitjumps(String test, int t, int f) {
		if( t != 0 && f != 0 ) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		}
		else if( t != 0 ) emit("if " + test + " goto L" + t);
		else if( f != 0 ) emit("iffalse " + test + " goto L" + f);
		else ; // ������ָ���Ϊt��f��ֱ�Ӵ�Խ
	}
	public String toString() { return op.toString(); }
}
