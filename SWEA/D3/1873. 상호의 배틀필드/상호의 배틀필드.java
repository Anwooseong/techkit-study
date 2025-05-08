import java.io.*;
import java.util.*;

public class Solution {
	
	static int T, H, W, targetX, targetY, dir;
	static char target;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(bf.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int i = 0; i < H; i++) {
				String line = bf.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						targetX = i;
						targetY = j;
						target = map[i][j];
						switch(map[i][j]) {
							case '^':
								dir = 0;
								break;
							case 'v':
								dir = 1;
								break;
							case '<':
								dir = 2;
								break;
							default:
								dir = 3;
						}
					}
				}
			}
			
			int cmdCnt = Integer.parseInt(bf.readLine());
			String line = bf.readLine();
			for(int i = 0; i < cmdCnt; i++) {
				char cmd = line.charAt(i);
				if(cmd == 'S') {
					shooting();
				}else {
					moveTarget(cmd);
				}
			}
			System.out.print("#"+testCase+" ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void moveTarget(char cmd) {
	    switch(cmd) {
	        case 'U': dir = 0; target = '^'; break;
	        case 'D': dir = 1; target = 'v'; break;
	        case 'L': dir = 2; target = '<'; break;
	        default:  dir = 3; target = '>'; break; // 'R'
	    }

	    int nextX = targetX + dx[dir];
	    int nextY = targetY + dy[dir];

	    if(isInRange(nextX, nextY) && map[nextX][nextY] == '.') {
	        map[targetX][targetY] = '.';
	        targetX = nextX;
	        targetY = nextY;
	    }

	    map[targetX][targetY] = target;
	}

	private static void shooting() {
		int x = targetX + dx[dir];
		int y = targetY + dy[dir];
		while(isInRange(x, y)) {
			if(map[x][y] == '#') {
				break;
			}else if(map[x][y] == '*') {
				map[x][y] = '.';
				break;
			}
			x = x + dx[dir];
			y = y + dy[dir];
		}
		
	}
	
	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}

	