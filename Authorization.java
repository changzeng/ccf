import java.util.*;

public class Authorization{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int authority_number = in.nextInt();
		HashMap<String,Integer> authorities = new HashMap<String,Integer>(authority_number);
		for(int i=0;i<authority_number;i++){
			putAuthority(in,authorities);
		}

		int role_number = in.nextInt(),a_number;
		HashMap<String,Role> roles = new HashMap<String,Role>(role_number);
		String role_name;
		for(int i=0;i<role_number;i++){
			role_name = in.next();
			a_number = in.nextInt();
			Role role = new Role(a_number);
			for(int j=0;j<a_number;j++){
				putAuthority(in,role.authorities);
			}
			roles.put(role_name,role);
		}

		//entering role
		int user_number = in.nextInt();
		String user_name;
		HashMap<String,User> users = new HashMap<String,User>(user_number);
		for(int i=0;i<user_number;i++){
			user_name = in.next();
			role_number = in.nextInt();
			User user = new User(role_number);
			for(int j=0;j<role_number;j++){
				role_name = in.next();
				user.putAuthority(roles.get(role_name).authorities);
			}
			users.put(user_name,user);
		}

		//query authorities
		int query_number = in.nextInt();
		int[] result = new int[query_number];
		String query_text;
		User user;
		for(int i=0;i<query_number;i++){
			user_name = in.next();
			query_text = in.next();
			user = users.get(user_name);
			if(user == null)
				result[i] = -1;
			else
				result[i] = user.queryAuthority(query_text);
		}

		for(int i=0;i<query_number;i++){
			if(result[i] == -1)
				System.out.println(false);
			else if(result[i] == -2)
				System.out.println(true);
			else
				System.out.println(result[i]);
			
		}
	}

	public static void putAuthority(Scanner in,HashMap<String,Integer> authorities){
		String text = in.next();
		String[] text_array = text.split(":");

		if(text_array.length == 2){
			authorities.put(text_array[0],Integer.parseInt(text_array[1]));
		}else{
			authorities.put(text_array[0],-1);
		}
	}
}

class Role{
	public HashMap<String,Integer> authorities;

	public Role(int authority_number){
		authorities = new HashMap<String,Integer>(authority_number);
	}
}

class User{
	public HashMap<String,Integer> authorities = new HashMap<String,Integer>();
	public int role_number;

	public User(int role_number){
		this.role_number = role_number;
	}

	public void putAuthority(HashMap<String,Integer> authority){
		Iterator iter = authority.entrySet().iterator();
		Integer tmp,value;
		String key;
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			key = (String)entry.getKey();
			value = (Integer)entry.getValue();

			tmp = this.authorities.get(key);
			if(tmp == null || tmp < value){
				this.authorities.put(key,value);
			}
		}
	}

	public int queryAuthority(String text){
		// System.out.println("hello");
		String[] text_array = text.split(":");

		if(authorities.get(text_array[0]) == null)
			return -1;

		if(text_array.length == 2){
			if(Integer.parseInt(text_array[1]) <= authorities.get(text_array[0]))
				return -2;
			else
				return -1;
		}else{
			// System.out.println(text);
			// System.out.println(authorities.get(text_array[0]));
			int result = authorities.get(text_array[0]);
			if(result == -1)
				return -2;
			else
				return result;
		}
	}
}