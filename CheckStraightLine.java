/*
 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        return IntStream.range(0, coordinates.length - 2)
				.allMatch(i -> isLine(coordinates[i], coordinates[i + 1], coordinates[i + 2]));
	}

	boolean isLine(int[] p1, int[] p2, int[] p3) {
		return (p2[1] - p1[1]) * (p3[0] - p1[0]) == (p3[1] - p1[1]) * (p2[0] - p1[0]);
        
    }
}