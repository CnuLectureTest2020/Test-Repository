package hw_03;

public class PlaneTest {
	public static void main(String args[]) {
		//모든 경우의 수 비행기들을 만들어보자!
		Plane[] planes = new Plane[8];
		
		planes[0] = new Plane();   //입력 X
		planes[1] = new Plane("대한항공"); //항공사만
		planes[2] = new Plane("OZ6615"); //비행기 모델만
		planes[3] = new Plane(120);  //최대인원만
		planes[4] = new Plane("대한항공", "KE7273"); //항공사와 비행기모델
		planes[5] = new Plane("대한항공", 150);  //항공사와 최대인원
		planes[6] = new Plane("OZ6615", 120);  //비행기 모델과 최대인원
		planes[7] = new Plane("대한항공", "KE7273", 150);  //전부!
		
		
		System.out.println("생성된 총 비행기의 수 : "+Plane.getPlane()); //getPlane메소드로 planes 출력
		System.out.println();
		
		for(int i=0; i<planes.length; i++) {
			System.out.println((i+1)+"번쨰 비행기 : ");
			System.out.print("항공사 - "+planes[i].setbrand()+"	비행기 모델 - "+planes[i].setmodel());
			System.out.println("	  최대 탑승가능 인원 - "+planes[i].setmax_people());
			System.out.println();
		}
		
	}
}
