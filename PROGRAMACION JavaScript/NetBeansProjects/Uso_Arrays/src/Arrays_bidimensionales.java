/**
 * @author Ernest Serna
 */
public class Arrays_bidimensionales {

    public static void main(String[] args) {
                
        int [][] matrix = new int [4][5];
        
        matrix[0][0]=15;
        matrix[0][1]=7;
        matrix[0][2]=89;
        matrix[0][3]=69;
        matrix[0][4]=3;
        
        matrix[1][0]=8;
        matrix[1][1]=88;
        matrix[1][2]=47;
        matrix[1][3]=26;
        matrix[1][4]=47;
        
        matrix[2][0]=55;
        matrix[2][1]=14;
        matrix[2][2]=16;
        matrix[2][3]=33;
        matrix[2][4]=44;
        
        matrix[3][0]=10;
        matrix[3][1]=11;
        matrix[3][2]=12;
        matrix[3][3]=13;
        matrix[3][4]=14;
        
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {    
                System.out.println(matrix[i][j]);
            }
            
        }
        
    }

}
