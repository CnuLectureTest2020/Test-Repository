package hw01;

public class Matrix {
	int row; //행을 나타내는 정수형 필드
	int col; //열을 나타내는 정수형 필드
	double [][] matrix; //행렬을 나타내는 2차원 배열
	
	int num = 0; //정해진 행을 초과하는 입력으로 인한 오류를 방지하는 필드값
	
	public Matrix(int row, int col) { //Matrix 클래스 생성자	
		matrix = new double[row][col];
		this.row = row;
		this.col = col;
	}
	
	public void setMatrix(double... d) {
		//인자로 온 값으로 행렬의 값을 1열부터 초기화
		if(num<row) {	//행을 초과하는 입력인가를 판단
			for(int i=0; i<col; i++) {
				matrix[num][i]=d[i];
			}
			num++;
		}
	}
	
	public Matrix addMatrix(Matrix otherMatrix) {
		//두 행렬의 합을 리턴
		Matrix result = new Matrix(row, col); //결과값으로 리턴할 행렬 생성
		
		for(int i=0; i<row; i++) { //두 행렬의 합의 경우 기존 행렬과 크기가 같음을 이용
			double[] d = new double[col]; //각 행의 열을 먼저 입력받고 행렬에 저장하는 방식으로 작동
			for(int j=0; j<col; j++) {
				d[j]=matrix[i][j]+otherMatrix.matrix[i][j]; //같은 행 같은 열의 값을 더하여 저장
			}
			result.setMatrix(d); //완성된 한 행의 열 값을 이미 작성된 메소드를 이용하여 저장한다
		}
		return result; //완성된 클래스인 행렬을 리턴
	}
	
	public Matrix multiMatrix(Matrix otherMatrix) {
		//두 행렬의 곱을 리턴
		Matrix result = new Matrix(row, otherMatrix.col); //결과값으로 리턴할 행렬 생성
		//행렬의 곱의 경우 결과적으로 나온 행렬은 첫번째 행렬의 행, 두번째 행렬의 열의 크키를 갖는 것을 이용
		for(int i=0; i<result.row; i++) { //result.row == row임
			double[] d = new double[result.col];
			for(int j=0; j<result.col; j++) { //result.col == otherMatrix.col임
				for(int n=0; n<otherMatrix.row; n++) { //덧셈과 같은 방식으로 작용하는 대신, 곱셈에서의 성질을 고려해야함
					/*한 행만을 수행한다 했을 때 곱셈의 경우 첫 번째 행렬의 열과 두 번째 행렬의 행을 곱하여 더함.
					 * 따라서 곱한 값을 먼저 저장한 후 반복문을 사용하여 다음 행렬에 더하여 저장하는 방식으로 수행 시 반복의 횟수는
					 * 첫 번째 행렬의 열(=두 번째 행렬의 행)의 크기만큼이다.*/
					d[j]+=matrix[i][n]*otherMatrix.matrix[n][j]; //행렬의 곱의 성질에 따라 곱한값을 더함
				}
			}
			result.setMatrix(d); //완성된 한 행을 결과 행렬에 저장
		}
		return result; //완성된 행렬의 리턴
	}
	public Matrix transposed() {
		//행렬의 전치 행렬을 리턴
		Matrix result = new Matrix(col, row); //행과 열의 크기가 뒤바뀜
		
		for(int i=0; i<col; i++) {
			double[] d = new double[row];
			for(int j=0; j<row; j++) {
				d[j]=matrix[j][i]; //행과 열의 위치를 바꾼 후 저장
			}
			result.setMatrix(d);
		}
		return result; //결과적으로 완성된 전치 행렬을 리턴함
	}
	public void print() {
		//행렬을 출력
		System.out.print(">>\n");
		for(int i=0; i<row; i++) {
			System.out.print("["); //행의 시작
			for(int j=0; j<col; j++) {
				System.out.print(matrix[i][j]);
				if(j<col-1)
					System.out.print(", "); //다음 열도 출력할 경우 구분을 위해 반점 출력
			}
			System.out.print("]\n"); //행의 끝, 다음 행으로 넘어간다
		}
		System.out.println();
	}
}
