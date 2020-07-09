
public class StackTester {

	public static void main(String[] args) {
			StackInfinitePush<String> stack = new StackInfinitePush<>(5);
			
			stack.push("ant");
			stack.push("bear");
			stack.push("cat");
			stack.push("dog");
			stack.push("elephant");
			
			while(!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
			System.out.println();
			
			stack.push("ant");
			stack.push("bear");
			stack.push("cat");
			stack.push("dog");
			stack.push("elephant");
			stack.push("frog");
			stack.push("giraffe");
			
			while(!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
			
		}

}
