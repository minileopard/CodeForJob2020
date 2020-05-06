package springRecruit;

public class April12_ks_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] pos = {
				{'*','.','*','*','.'},
				{'*','.','*','*','*'},
				{'*','.','*','*','.'}
		};
		System.out.println(GetMaxStaffs(pos));
	}
	public static int GetMaxStaffs (char[][] pos) {
		if(pos == null || pos.length == 0)
			return 0;
		int row = pos.length, col = pos[0].length;
		if(row == 1 && (col == 1 || col == 2))
            return 0;
        else if(col == 1 && (row == 1 || row == 2))
        	return 0;
		int count = 0;
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(pos[i][j] == '.')
					count++;
			}
		}
		
		return count;
        // write code here
    }
}
