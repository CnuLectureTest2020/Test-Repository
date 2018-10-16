package marketProgram;

import java.util.Scanner;

public class Market {
	static int array_length; // 정적 변수

	Scanner sc;

	Fruit[] F;
	Beer[] B;
	Drink[] D;
	Ramen[] R;
	Snack[] S;

	int indexF = 0;
	int indexB = 0;
	int indexD = 0;
	int indexR = 0;
	int indexS = 0;

	public Market() {
		sc = new Scanner(System.in);
		array_length = 10;
		F = new Fruit[array_length];
		B = new Beer[array_length];
		D = new Drink[array_length];
		R = new Ramen[array_length];
		S = new Snack[array_length];
	}

	public Fruit[] getF() {
		return F;
	}

	public Beer[] getB() {
		return B;
	}

	public Drink[] getD() {
		return D;
	}

	public Ramen[] getR() {
		return R;
	}

	public Snack[] getS() {
		return S;
	}

	public void SetNamePriceProduct(String category, String... name) {
		if (category.toLowerCase().equals("beer")) {
			for (String n : name) {
				if(indexB < array_length) {
					int r = 0;
					System.out.println("name : " + n);
					while (r == 0) {
						System.out.print("price : ");
						int p = sc.nextInt();
						if (p >= 500 && p <= 2500) {
							B[indexB++] = new Beer(n, p);
							r++;
						} else {
							System.out.println("!!input error");
						}
					}
				}
			}
		} else if (category.toLowerCase().equals("fruit")) {
			for (String n : name) {
				if(indexF < array_length) {
					int r = 0;
					System.out.println("name : " + n);
					while (r == 0) {
						System.out.print("price : ");
						int p = sc.nextInt();
						if (p >= 500 && p <= 2500) {
							F[indexF++] = new Fruit(n, p);
							r++;
						} else {
							System.out.println("!!input error");
						}
					}
				}
			}
		} else if (category.toLowerCase().equals("drink")) {
			for (String n : name) {
				if(indexD < array_length) {
					int r = 0;
					System.out.println("name : " + n);
					while (r == 0) {
						System.out.print("price : ");
						int p = sc.nextInt();
						if (p >= 500 && p <= 2500) {
							D[indexD++] = new Drink(n, p);
							r++;
						} else {
							System.out.println("!!input error");
						}
					}
				}
			}
		} else if (category.toLowerCase().equals("ramen")) {
			for (String n : name) {
				if(indexR < array_length) {
					int r = 0;
					System.out.println("name : " + n);
					while (r == 0) {
						System.out.print("price : ");
						int p = sc.nextInt();
						if (p >= 500 && p <= 2500) {
							R[indexR++] = new Ramen(n, p);
							r++;
						} else {
							System.out.println("!!input error");
						}
					}
				}
			}
		} else if (category.toLowerCase().equals("snack")) {
			for (String n : name) {
				if(indexS < array_length) {
					int r = 0;
					System.out.println("name : " + n);
					while (r == 0) {
						System.out.print("price : ");
						int p = sc.nextInt();
						if (p >= 500 && p <= 2500) {
							S[indexS++] = new Snack(n, p);
							r++;
						} else {
							System.out.println("!!input error");
						}
					}
				}
			}
		}
	}

	public void print(Fruit[] f, Beer[] b, Drink[] d, Ramen[] r, Snack[] s) {
		System.out.println("********************** Product ************************");
		print(f);// 각각의 상품을 출력하기 위해 중복메소드로 사용
		print(b);
		print(d);
		print(r);
		print(s);
		System.out.println("*******************************************************");
	}

	private void print(Fruit[] f) {
		System.out.println("FRUIT :");
		for (int i = 0; i < indexF; i++)
			System.out.println("		name : " + f[i].getname() + ", price : " + f[i].getprice());
	}

	private void print(Beer[] b) {
		System.out.println("BEER :");
		for (int i = 0; i < indexB; i++)
			System.out.println("		name : " + b[i].getname() + ", price : " + b[i].getprice());
	}

	private void print(Drink[] d) {
		System.out.println("DRINK :");
		for (int i = 0; i < indexD; i++)
			System.out.println("		name : " + d[i].getname() + ", price : " + d[i].getprice());
	}

	private void print(Ramen[] r) {
		System.out.println("RAMEN :");
		for (int i = 0; i < indexR; i++)
			System.out.println("		name : " + r[i].getname() + ", price : " + r[i].getprice());
	}

	private void print(Snack[] s) {
		System.out.println("SNACK :");
		for (int i = 0; i < indexS; i++)
			System.out.println("		name : " + s[i].getname() + ", price : " + s[i].getprice());
	}
}
