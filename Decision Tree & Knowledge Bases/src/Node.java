/*
 * THERE ARE TWO TYPES OF NODES FOR THE KNOWLEDGE BASE: - question (Parent)
 * nodes: Example - Is it a beverage? - meal item (Leaf) nodes: Example - Coffee
 * The content of a question node is the question to ask; The content of a
 * meal-item node is a non yes or no answer to the question. A meal-item node
 * can be turned into a question node when a proposed answer fails
 */

public class Node {
	// DATA MEMBERS
	public boolean isQuestion; // TRUE IF IT IS A QUESTION, FALSE IF IT IS AN ANSWER
	public String contents; // Question or meal-item as the case may be
	public Node no; // left branch
	public Node yes; // right branch

	Node(String question, Node noNode, Node yesNode) {
		isQuestion = true;
		contents = question;
		no = noNode;
		yes = yesNode;
	}

	Node(String mealItemAnswer) {
		isQuestion = false;
		contents = mealItemAnswer;
		no = null;
		yes = null;
	}

	// A MEAL-ITEM NODE WILL BE TURNED INTO A QUESTION NODE WHEN A PROPOSED ANSWER
	// FAILS.
	void convertToQuestion(String question, Node noNode, Node yesNode) {
		isQuestion = true;
		contents = question;
		no = noNode;
		yes = yesNode;
	}
}