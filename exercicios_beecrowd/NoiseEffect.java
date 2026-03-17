import java.util.Scanner;

public class NoiseEffect {

    static int[][] rotate90(int[][] m, int n) {
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r[j][n - 1 - i] = m[i][j];
        return r;
    }

    static int[][] flipHorizontal(int[][] m, int n) {
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r[i][j] = m[i][n - 1 - j];
        return r;
    }

    static int countMatching(int[][] standard, int[][] scanned, int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (Math.abs(standard[i][j] - scanned[i][j]) <= 100)
                    count++;
        return count;
    }

    static int bestMatch(int[][] standard, int[][] base, int n) {
        int max = 0;
        int[][] current = base;
        for (int r = 0; r < 4; r++) {
            int count = countMatching(standard, current, n);
            if (count > max) max = count;
            current = rotate90(current, n);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int imageSize;

        while (true) {
            imageSize = reader.nextInt();
            if (imageSize == 0) break;

            int[][] standardImage = new int[imageSize][imageSize];
            int[][] capturedImage = new int[imageSize][imageSize];

            for (int i = 0; i < imageSize; i++)
                for (int j = 0; j < imageSize; j++)
                    standardImage[i][j] = reader.nextInt();

            for (int i = 0; i < imageSize; i++)
                for (int j = 0; j < imageSize; j++)
                    capturedImage[i][j] = reader.nextInt();

            // Check all 8 orientations: 4 rotations + 4 rotations of the flipped image
            int maxCount = bestMatch(standardImage, capturedImage, imageSize);
            int flippedCount = bestMatch(standardImage, flipHorizontal(capturedImage, imageSize), imageSize);
            if (flippedCount > maxCount) maxCount = flippedCount;

            float pct = (maxCount / (float)(imageSize * imageSize)) * 100f;
            System.out.printf("%.2f\n", pct);
        }

        reader.close();
    }
}