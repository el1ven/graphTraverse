import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class graphTraverse {

    public static void bfsMethod(int[][] adjMatrix, int sourceNode){
        //利用队列
        Queue<Integer> queue = new LinkedList<Integer>();
        int numOfNodes = adjMatrix[sourceNode].length;
        int[] isVisited = new int[numOfNodes];//没访问过的初始化为0

        isVisited[sourceNode] = 1;
        queue.add(sourceNode);

        int i = 0;//index表示
        int element = 0;//当前元素

        while(!queue.isEmpty()){
            element = queue.remove();
            System.out.print(element+" ");
            i = 0;
            while(i < numOfNodes){
                if(adjMatrix[element][i] == 1 && isVisited[i] == 0){
                    queue.add(i);//按照最先遍历到的1进入队列为原则, 如果有好几个1在一行,也就是一个顶点与多个顶点相连
                    isVisited[i] = 1;
                }
                i++;
            }
        }
    }

    public static void dfsMethod(int [][] adjMatrix, int sourceNode){
        //利用栈,因为需要回溯,弹出一个节点的同时把它的儿子压入栈中,把儿子弹出来时，把孙子压入栈中,所以就可以按深度了
        Stack<Integer> stack = new Stack<Integer>();
        int numOfNodes = adjMatrix[sourceNode].length;
        int[] isVisited = new int[numOfNodes];

        stack.push(sourceNode);
        isVisited[sourceNode] = 1;

        int element = 0;

        while(!stack.isEmpty()){
            element = stack.pop();
            System.out.println(element + " ");
            for(int i = 0; i < numOfNodes; i++){
                 if(adjMatrix[element][i] == 1 && isVisited[i] == 0){
                     stack.push(i);
                     isVisited[i] = 1;
                 }
            }
        }
    }

    public static void main(String[] args){

        int numOfNodes = 0;
        int sourceNode = 0;//设置哪一个点为起始点
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入图的节点总数：");
        numOfNodes = scanner.nextInt();

        int[][] adjMatrix = new int[numOfNodes][numOfNodes];
        System.out.println("请输入图的临接矩阵：");
        for(int i = 0; i < numOfNodes; i++){
            for(int j = 0; j < numOfNodes; j++){
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("请输入图开始遍历的起点Source(从0开始编号):");
        sourceNode = scanner.nextInt();

        System.out.println("图的广度优先遍历(BFS)结果为(从0开始编号):");
        bfsMethod(adjMatrix, sourceNode);

        System.out.println("\n图的深度优先遍历(DFS)结果为(从0开始编号):");
        dfsMethod(adjMatrix, sourceNode);

        scanner.close();

    }
}
