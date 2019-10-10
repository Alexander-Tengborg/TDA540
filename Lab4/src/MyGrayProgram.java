public class MyGrayProgram { 
   public static void main(String[] args) throws Exception{ 
      int[][] original = GrayImage.read("mushroom.jpeg"); 
      int[][] manipulated = contour(original);
      GrayImage.write("upDownMushroom.jpeg", manipulated); 
      GrayImageWindow iw = new GrayImageWindow(original, manipulated); 
   }//main 

   public static int[][] upDown(int[][] samples) { 
      int[][] newSamples = new int[samples.length][samples[0].length]; 
      for(int row = 0; row < samples.length; row = row + 1)
         for(int col = 0; col < samples[row].length; col = col + 1)
            newSamples[row][col] = samples[samples.length - row - 1 ][col]; 
      return newSamples; 
    }//upDown

   public static int[][] leftRight(int[][] samples) {
      int[][] newSamples = new int[samples.length][samples[0].length];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++)
            newSamples[row][col] = samples[row][samples[row].length - col - 1];
      return newSamples;
   }

   public static int[][] invert(int[][] samples) {
      int[][] newSamples = new int[samples.length][samples[0].length];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++)
            newSamples[row][col] = 255-samples[row][col];
      return newSamples;
   }

   public static int[][] toBlackWhite(int[][] samples) {
      int[][] newSamples = new int[samples.length][samples[0].length];
      for(int row = 0; row < samples.length; row++)
         for(int col = 0; col < samples[row].length; col++) {
            int newColor = (samples[row][col] < 128) ? 0 : 255;
            newSamples[row][col] = newColor;
         }
      return newSamples;
   }

   public static int[][] contour(int[][] samples) {
      samples = toBlackWhite(samples);
      int[][] newSamples = new int[samples.length][samples[0].length];
      for(int row = 0; row < samples.length; row++) {
         for (int col = 0; col < samples[row].length; col++) {
            if(col == 0 || col == (samples[row].length - 1) || row == 0 || row == (samples.length - 1)) {
               newSamples[row][col] = samples[row][col];
               continue;
            }

            int newColor;

            if (samples[row][col] == 0 && hasWhiteNeighbour(samples, row, col)) {
               newColor = 0;
            } else {
               newColor = 255;
            }
            newSamples[row][col] = newColor;
         }
      }
      return newSamples;
   }

   public static boolean hasWhiteNeighbour(int[][] samples, int row, int col) {
      for(int curRow = row - 1; curRow <= (row + 1); curRow++) {
         if(curRow < 0 || curRow > (samples.length - 1)) continue;
         for(int curCol = col - 1; curCol <= (col + 1); curCol++) {
            if(curCol < 0 || curCol > (samples[row].length - 1) || (curCol == col && curRow == row)) continue;
            if(samples[curRow][curCol] == 255) return true;
         }
      }
      return false;
   }
}//MyGrayProgram
