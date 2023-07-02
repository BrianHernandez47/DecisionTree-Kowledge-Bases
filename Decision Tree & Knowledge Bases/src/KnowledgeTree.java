import java.util.Scanner;

public class KnowledgeTree {
	// DATA MEMBER: THE ROOT POINTER TO THE TOP OF THE KNOWLEDGE TREE
	private Node root;

	// CONSTRUCTOR
	public KnowledgeTree() {
		// CREATE THE INITIAL KNOWLEDGE TREE USING A FIRST QUESTION AND TWO MEAL ITEMS
		String mainSubjectContent = "Is it a beverage?";
		Node yesBeverage = new Node("wine");
		Node noBeverage = new Node("steak");
		Node mainSubject = new Node(mainSubjectContent, noBeverage, yesBeverage);
		root = mainSubject;
	}

	// MEMBER METHODS
	// --------------------------------------------------------------------------
	// ASKS THE USER A YES OR NO QUESTION - RETURNS TRUE IF YES AND FALSE IF NO
	// --------------------------------------------------------------------------
	private static boolean askYesNo(String question) {
		Scanner in = new Scanner(System.in);
		String answer;
		for (;;) {
			System.out.print(question + " ");
			answer = in.nextLine();
			if (answer.equals("yes"))
				return true;
			else if (answer.equals("no"))
				return false;
			else
				System.out.println("Answers must be yes or no");
		}
	}
	// --------------------------------------------------------------------------
	// BUILDS THE DECISION TREE BY ADDING A QUESTION NODE AT THE APPROPRIATE
	// LOCATION
	// --------------------------------------------------------------------------
	public void buildKnowledgeNode() {
		Scanner in = new Scanner(System.in);

		// TASK 1: BEGIN BY PROPOSING A MEAL ITEM
		System.out.println("Please think of a meal item and answer the following yes or no questions.");

		// TASK 2: NAVIGATE DOWN THE TREE USING ANSWERS TO YES OR NO QUESTIONS
		// END THE NAVIGATION WHEN THERE ARE NO MORE QUESTIONS TO ASK
		// SEARCH THE DECISION TREE BY STARTING AT THE ROOT
		Node currentNode = root;
		while (currentNode.isQuestion) {
			if (askYesNo(currentNode.contents))
				currentNode = currentNode.yes;
			else
				currentNode = currentNode.no;
		}
		// TASK 3: IF THE MEAL ITEM DOES NOT EXIST IN THE KNOWLEDGE TREE, ADD IT
		if (!askYesNo("Is this meal item " + currentNode.contents + "? ")) {
			// a. get the meal item name
			System.out.print("Name the meal item you are thinking of: ");
			String userAnswer = in.nextLine();
			// b. identify a yes or no question that distinguishes this meal item
			System.out.println(
					"Supply a yes/no question that would distinguish " + userAnswer + " from " + currentNode.contents);
			String userQuestion = in.nextLine();
			// c. add the question node by repositioning the yes and no answers

			// yes
			if (askYesNo("Is the answer yes or no for " + userAnswer + "? ")) {
				Node noTemp = new Node(currentNode.contents);
				Node yesTemp = new Node(userAnswer);
				currentNode.convertToQuestion(userQuestion, noTemp, yesTemp);
			}
			// no
			else {
				Node noTemp = new Node(userAnswer);
				Node yesTemp = new Node(currentNode.contents);
				currentNode.convertToQuestion(userQuestion, noTemp, yesTemp);
			}
			System.out.println(userAnswer + " has now been added to the knowledge base.");
		} else
			System.out.println("Great!");
	}
}