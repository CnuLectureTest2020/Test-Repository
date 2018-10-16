package hw01;

public class TestAnimal {
	public static void main(String[] args) {
		Fish fish = new Fish();
		Cat cat = new Cat("나비");
		Animal a_fish = new Fish();
		Animal a_spider = new Spider();
		Pet pet = new Cat();
		
		System.out.println("**FIsh의 메소드 호출");
		fish.setName("붕어싸만코");
		System.out.println("물고기의 이름은 " + fish.getName() + "입니다");
		fish.play();
		fish.eat();
		fish.walk();
		System.out.println();
		
		System.out.println("**Cat의 메소드 호출");
		System.out.println("고양이의 이름은 " + cat.getName() + "입니다");
		cat.setName("페르시안");
		System.out.println("고양이의 이름을 " + cat.getName() + "(으)로 바꿨습니다.");
		cat.play();
		cat.eat();
		cat.walk();
		System.out.println();
		
		System.out.println("**Animal Fish의 메소드 호출");
		a_fish.eat();
		a_fish.walk();
		System.out.println();
		
		System.out.println("**Animal Spider의 메소드 호출");
		a_spider.eat();
		a_spider.walk();
		System.out.println();
		
		System.out.println("**Pet Cat의 메소드 호출");
		pet.play();
		pet.setName("맥킨토시");
		System.out.println("애완 동물의 이름을 " + pet.getName() + "(으)로 변경합니다.");
		System.out.println();
		
		System.out.println("**객체에 대한 강제 변환");
		((Fish)a_fish).play();
		((Fish)a_fish).walk();
		((Fish)a_fish).eat();
		System.out.println();
		
		System.out.println("**다형성 테스트");
		Animal[] animal = new Animal[3];
		animal[0] = a_spider;
		animal[1] = cat;
		animal[2] = fish;
		for( int i = 0; i < 3; i++ ){
			animal[i].walk();
			animal[i].eat();
		}
		System.out.println();
	}
}
