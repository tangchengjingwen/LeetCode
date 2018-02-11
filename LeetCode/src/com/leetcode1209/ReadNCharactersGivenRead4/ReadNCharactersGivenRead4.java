package com.leetcode1209.ReadNCharactersGivenRead4;

//		

//		
//		The API: int read4(char *buf) reads 4 characters at a time from a file.
//		
//		The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//		
//		By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//		
//		Note:
//		The read function will only be called once for each test case.

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class ReadNCharactersGivenRead4 extends Reader4 {
	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		char[] tmp = new char[4];
		int index = 0;
		while(true) {
			int count = Reader4.read4(tmp);
			count = Math.min(count, n - index);
			for (int i = 0 ; i < count; i++) {
				buf[index++] = tmp[i];
			}
			if (index == n || count < 4) {
				return index;
			}
		}
	}
}

class Reader4 {
	static int read4(char[] buf) {
		return 0;
	};
}