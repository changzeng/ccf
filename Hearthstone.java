import java.util.*;

class Hearthstone{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		Player[] players = new Player[2];
		players[0] = new Player();
		players[1] = new Player();

		//get command number
		String command;
		int operator;
		int command_number = in.nextInt();
		Player current_player = players[0];
		Player opposite_player = players[1];
		for(int i=0;i<command_number;i++){
			command = in.next();
			if(command.equals("summon")){
				int position = in.nextInt();
				int attack = in.nextInt();
				int health = in.nextInt();

				Attendant tmp = new Attendant(attack,health);
				current_player.addAttendant(position,tmp);
			}else if(command.equals("attack")){
				int attacker_position = in.nextInt();
				int defender_position = in.nextInt();

				Attendant attacker = current_player.getAttendant(attacker_position);
				Attendant defender = opposite_player.getAttendant(defender_position);

				int result = attacker.attack(defender);
				if(result == -2){
					current_player.removeAttendant(attacker_position);
					opposite_player.removeAttendant(defender_position);
				}else if(result == -1){
					opposite_player.removeAttendant(defender_position);
				}else if(result == 1){
					current_player.removeAttendant(attacker_position);
				}
			}else if(command.equals("end")){
				Player tmp = current_player;
				current_player = opposite_player;
				opposite_player = tmp;
			}
		}

		if(players[0].isAlive() && players[1].isAlive() || !players[0].isAlive() && !players[1].isAlive()){
			output(0);
		}else if(players[0].isAlive() && !players[1].isAlive()){
			output(1);
		}else if(!players[0].isAlive() && players[1].isAlive()){
			output(-1);
		}
		changeLine();

		for(int i=0;i<2;i++){
			Player tmp = players[i];
			output(tmp.health);
			changeLine();
			output(tmp.attendants.size());

			for(int j=0;j<tmp.attendants.size();j++)
				output(tmp.attendants.get(j).health);
			changeLine();
		}
	}

	public static void output(String s){
		System.out.print(s);
		System.out.print(" ");
	}

	public static void output(int i){
		System.out.print(i);
		System.out.print(" ");
	}

	public static void changeLine(){
		System.out.println();
	}
}

class Attendant{
	public int attack;
	public int health;

	public Attendant(int attack,int health){
		this.attack = attack;
		this.health = health;
	}

	//attack attendant
	public int attack(Attendant attendant){
		Attendant tmp = attendant;

		this.health -= tmp.attack;
		tmp.health -= this.attack;

		if(this.health <= 0 && tmp.health <= 0){
			return -2;
		}else if(this.health > 0 && tmp.health <= 0){
			return -1;
		}else if(this.health > 0 && tmp.health > 0){
			return 0;
		}else{
			return 1;
		}
	}

	//attack player
	public int attack(Player player){
		Player tmp = player;

		this.health -= tmp.attack;
		tmp.health -= this.attack;

		if(this.health <= 0 && tmp.health <= 0){
			return -2;
		}else if(this.health > 0 && tmp.health <= 0){
			return -1;
		}else if(this.health > 0 && tmp.health > 0){
			return 0;
		}else{
			return 1;
		}
	}
}

class Player{
	List<Attendant> attendants;
	int attack = 0;
	int health = 30;

	public Player(){
		attendants = new ArrayList<Attendant>(7);
	}

	public void addAttendant(int position,Attendant attendant){
		// System.out.println("add");
		attendants.add(position-1,attendant);
	}

	public Attendant getAttendant(int position){
		return this.attendants.get(position - 1);
	}

	public Attendant removeAttendant(int position){
		return this.attendants.remove(position-1);
	}

	public boolean isAlive(){
		return this.health > 0;
	}

	//attack attendant
	public int attack(Attendant attendant){
		Attendant tmp = attendant;

		this.health -= tmp.attack;
		tmp.health -= this.attack;

		if(this.health <= 0 && tmp.health <= 0){
			return -2;
		}else if(this.health > 0 && tmp.health <= 0){
			return -1;
		}else if(this.health > 0 && tmp.health > 0){
			return 0;
		}else{
			return 1;
		}
	}

	//attack player
	public int attack(Player player){
		Player tmp = player;

		this.health -= tmp.attack;
		tmp.health -= this.attack;

		if(this.health <= 0 && tmp.health <= 0){
			return -2;
		}else if(this.health > 0 && tmp.health <= 0){
			return -1;
		}else if(this.health > 0 && tmp.health > 0){
			return 0;
		}else{
			return 1;
		}
	}
}