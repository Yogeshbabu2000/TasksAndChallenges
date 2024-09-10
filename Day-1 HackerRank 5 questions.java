//1.-------------Anagram are not------------
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        a=a.toLowerCase();
        b=b.toLowerCase();
        if(a.length()!=b.length())
        return false;
        // Complete the function
        else{
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                if(a.charAt(i)==b.charAt(j)){
                    b=b.substring(0, j)+b.substring(j+1);
                    break;
                }
            }
        }
        }
        return b.length()==0?true:false;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

//----------------2.String Tokens--------------
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s=s.trim();
        
        String a[]=s.split("[ !,?._'@]+");
        
        if(s.length()==0||s.length()>400000){
            System.out.println(0);
            return;
        }else{
            System.out.println(a.length);
            for(String b:a)
            System.out.println(b);
        }
        scan.close();
    }
}

//-------------------3.Java Stack(balanced String or not)---------
import java.util.*;
class Solution{
    
    public static boolean fun(String s){
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray()){
           if(ch=='('||ch=='['||ch=='{')
           stack.push(ch);
           
           else if(ch==')'||ch==']'||ch=='}'){
               if(stack.isEmpty())
               return false;
               char top=stack.pop();
               if((ch==')'&&top!='(')||(ch==']'&&top!='[')||(ch=='}'&&top!='{'))
               return false;
           }
           
        }
        return stack.isEmpty();
    }
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(fun(input));
		}
	}
}

//------------------4.Java Comparator---------------
import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player>{
    @Override
    public int compare(Player p1,Player p2){
        // if(p1.score>p2.score) return -1;
        // else if(p1.score<p2.score) return 1;
        // else {
        //     if(p1.name.compareTo(p2.name)>0)return 1;
        //     else if(p1.name.compareTo(p2.name)<0)return -1;
        //     else return 0;
        // }
        return p1.score - p2.score == 0 ? p1.name.compareTo(p2.name) : p2.score - p1.score;
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

//-------------------5.Java Sort-------------------
import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class SortClass implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2){
        if(s1.getCgpa()>s2.getCgpa()) return -1;
        else if(s1.getCgpa()<s2.getCgpa()) return 1;
        else{
            if(s1.getFname().compareTo(s2.getFname())>0) return 1;
            else if(s1.getFname().compareTo(s2.getFname())<0) return -1;
            else return 0;
        }
    }
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        Collections.sort(studentList,new SortClass());
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



