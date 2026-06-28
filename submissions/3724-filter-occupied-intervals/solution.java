class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] list, int freeStart, int freeEnd) {
        Arrays.sort(list, (x, y) -> Integer.compare(x[0],y[0]));  
        //System.out.println("Input intervals:");
        for (int[] x : list) {
            System.out.println(Arrays.toString(x));
        }

        //System.out.println("Free interval: [" + freeStart + ", " + freeEnd + "]");

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> prev = new ArrayList<>();
        prev.add(list[0][0]);
        prev.add(list[0][1]);

        int[] curr;

        ans.add(prev);

        //System.out.println("\nInitial ans: " + ans);

        // Merge intervals
        for (int i = 1; i < list.length; i++) {

            prev = ans.get(ans.size() - 1);
            curr = list[i];

            //System.out.println("\nComparing:");
            //System.out.println("prev = " + prev);
            //System.out.println("curr = " + Arrays.toString(curr));

            if (prev.get(1) - curr[0] >= -1) {

                System.out.println("Overlapping");

                if (curr[1] > prev.get(1)) {

                    System.out.println("Extending interval");

                    ans.remove(ans.size() - 1);
                    ans.add(Arrays.asList(prev.get(0), curr[1]));
                }

            } else {

                //System.out.println("No overlap, adding new interval");

                ans.add(Arrays.asList(curr[0], curr[1]));
            }

            //System.out.println("Current ans = " + ans);
        }

        //System.out.println("\nAfter merging: " + ans);

        // Remove free interval
        for (int i = 0; i < ans.size(); i++) {

            prev = ans.get(i);

            //System.out.println("\nProcessing interval: " + prev);

            if (freeStart > prev.get(1) ||
                (freeStart < prev.get(0) && freeEnd < prev.get(0))) {

                //System.out.println("No intersection, continuing");
                continue;
            }

            if (prev.get(0) >= freeStart) {

                //System.out.println("Interval starts inside free range");

                if (prev.get(1) > freeEnd) {

                    //System.out.println("Keeping right part only");

                    ans.set(i, Arrays.asList(freeEnd + 1, prev.get(1)));

                } else {

                    //System.out.println("Removing entire interval");

                    ans.remove(i);
                    i--; // important after removal
                }

            } else {

                //System.out.println("Interval starts before free range");

                if (prev.get(1) > freeEnd) {

                    //System.out.println("Splitting into two intervals");

                    ans.set(i, Arrays.asList(prev.get(0), freeStart - 1));
                    ans.add(i + 1, Arrays.asList(freeEnd + 1, prev.get(1)));

                    i++; // skip newly inserted interval

                } else {

                    //System.out.println("Keeping left part only");

                    ans.set(i, Arrays.asList(prev.get(0), freeStart - 1));
                }
            }

            //System.out.println("Current ans = " + ans);
        }

        //System.out.println("\nFinal answer: " + ans);

        return ans;
    }
}
