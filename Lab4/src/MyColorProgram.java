public class MyColorProgram { 
   public static void main(String[] args) throws Exception { 
      int[][][] original = ColorImage.read("mushroom.jpeg"); 
      int[][][] manipulated = sharpenOne(original);
      ColorImage.write("upDownMushroom.jpeg", manipulated); 
      ColorImageWindow iw = new ColorImageWindow(original, manipulated); 
   }//main 

   public static int[][][] upDown(int[][][] samples) { 
      int[][][] newSamples = new int[samples.length][samples[0].length][3]; 
      for(int row = 0; row < samples.length; row = row + 1)
         for(int col = 0; col < samples[row].length; col = col + 1)
            for(int c = 0; c < samples[row][col].length; c = c + 1)
               newSamples[row][col][c] = samples[samples.length-row-1][col][c]; 
      return newSamples; 
   }//upDown

   public static int[][][] leftRight(int[][][] samples) {
      int[][][] newSamples = new int[samples.length][samples[0].length][3];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++)
            newSamples[row][col] = samples[row][samples[row].length - col - 1];
      return newSamples;
   }

   public static int[][][] invert(int[][][] samples) {
      int[][][] newSamples = new int[samples.length][samples[0].length][3];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++)
            for(int c = 0; c < samples[row][col].length; c++)
               newSamples[row][col][c] = 255 - samples[row][col][c];

      //newSamples[row][col] = 255-samples[row][col];
      return newSamples;
   }

   public static int[][][] toGray(int[][][] samples) {
      int[][][] newSamples = new int[samples.length][samples[0].length][3];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++) {
            double L = samples[row][col][0] * 0.299 + samples[row][col][1] * 0.587 + samples[row][col][2] * 0.114;
            for(int c = 0; c < samples[row][col].length; c++)
               newSamples[row][col][c] = (int)L;
         }

      //newSamples[row][col] = 255-samples[row][col];
      return newSamples;
   }

   public static int[][][] toBlackWhite(int[][][] samples) {
      int[][][] newSamples = new int[samples.length][samples[0].length][3];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++) {
            double L = samples[row][col][0] * 0.299 + samples[row][col][1] * 0.587 + samples[row][col][2] * 0.114;
            int newColor = (L < 128) ? 0 : 255;
            for(int c = 0; c < samples[row][col].length; c++)
               newSamples[row][col][c] = newColor;
         }

      //newSamples[row][col] = 255-samples[row][col];
      return newSamples;
   }

   public static int[][][] sharpenOne(int[][][] samples) {
      int[][][] newSamples = new int[samples.length][samples[0].length][3];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++) {

            for(int c = 0; c < samples[row][col].length; c++)
               newSamples[row][col] = sharpenOneFilter(samples, row, col);
         }

      //newSamples[row][col] = 255-samples[row][col];
      return newSamples;
   }

   public static int[] sharpenOneFilter(int[][][] samples, int row, int col) {
      int[] newColors = new int[3];
      for(int i = 0; i < 3; i++)
         newColors[i] = 9*samples[row][col][i];

      for(int curRow = row - 1; curRow <= (row + 1); curRow++) {
         if(curRow < 0 || curRow > (samples.length - 1)) continue;
         for(int curCol = col - 1; curCol <= (col + 1); curCol++) {
            if(curCol < 0 || curCol > (samples[row].length - 1) || (curCol == col && curRow == row)) continue;
            for(int i = 0; i < 3; i++) {
               int newColor = samples[row][col][i];
               if(newColor > 255) newColor = 255;
               if(newColor < 0) newColor = 0;
               newColors[i] -= newColor;
            }

            /*newRed -= samples[curRow][curCol][0];
            newGreen -= samples[curRow][curCol][1];
            newBlue -= samples[curRow][curCol][2];*/
         }
      }
      System.out.println("Old: " + samples[row][col][0] + "   New: " +  newColors[2]);
      return newColors;
   }
}//MyColorProgram
