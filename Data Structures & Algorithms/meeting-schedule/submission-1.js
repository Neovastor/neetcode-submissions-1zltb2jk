/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {boolean}
     */
    canAttendMeetings(intervals) {
        intervals = intervals.sort((a,b) => a.start- b.start);

        let i = 1;
        let prevInterval = intervals[0];
        while(i < intervals.length){
            if (prevInterval.end <= intervals[i].start){
                prevInterval = intervals[i]; 
            } else {
                return false;
            }

            i++;
        }
        return true;
    }
}
