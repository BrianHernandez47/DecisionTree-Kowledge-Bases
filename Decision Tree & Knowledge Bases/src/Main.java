
public class Main {

	public static void main(String[] args) {
		// TASK 1: CONSTRUCT A BINARY TREE TO HOLD THE KNOWLEDGE BASE
		KnowledgeTree knowledgeTree = new KnowledgeTree();

		// TASK 2: BUILD THE KNOWLEDGE BASE AS A DECISION TREE USING
		// YES/NO QUESTIONS AND FINAL ANSWERS
		for (;;) {
			knowledgeTree.buildKnowledgeNode();
			System.out.println();
		}
	}
}