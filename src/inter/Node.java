package inter;

import lexer.*;

public class Node {
	int lexline = 0; // ������Ӧ�Ĺ�����Դ�����е��к�

	Node() { lexline = Lexer.line; }

	void error(String s) { throw new Error("near line "+lexline+": "+s); }

	// ��������ַ��
	static int labels = 0;
	public int newlabel() { return ++labels; }
	/**
	 * ���һ��label���
	 * @param i ��ŵ�ֵ
	 */
	public void emitlabel(int i) { System.out.print("L" + i + ":"); }
	/**
	 * ���һ���ַ���
	 * @param s Ҫ�����ֵ
	 */
	public void emit(String s) { System.out.println("\t" + s); }
}