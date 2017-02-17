/**
	Programmatically
*/

class dropEggs
{
    // Find max of two integers
    static int max(int a, int b) {
        //returns a if its greater than b else returns b
        return (a > b) ? a : b;
    }

    /*
        e => number of eggs
        f => number of floors
    */
    static int dropEggs(int e, int f)
    {

        int eggFloor[][] = new int[e+1][f+1];
        int res;
        int i, j, x;

        for (i = 1; i <= e; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (j = 1; j <= f; j++)
            eggFloor[1][j] = j;
        
        for (i = 2; i <= e; i++)
        {
            for (j = 2; j <= f; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                    res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
        return eggFloor[e][f];
    }

    public static void main(String args[] )
    {
        int e = 2, f = 100;
        System.out.println("Worst Case given " + e +" eggs and " + f + " floors is " + dropEggs(e, f));
    }
}
