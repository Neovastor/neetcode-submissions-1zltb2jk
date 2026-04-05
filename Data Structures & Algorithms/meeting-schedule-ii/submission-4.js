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
     * @returns {number}
     */
    minMeetingRooms(intervals) {
        let start = [];
        let end = [];
        intervals.forEach((interval) => {
            start.push(interval.start);
            end.push(interval.end);
        })
        start = start.sort((a,b) => a - b);
        end = end.sort((a,b) => a - b);

        let indexStart = 0;
        let indexEnd = 0;
        let count = 0;
        let result = 0;
        while(indexStart < start.length){
            if (start[indexStart] < end[indexEnd]){
                count++;

                result = Math.max(result,count);
                indexStart++;
            } else {
                count--;
                indexEnd++;
            }            
        }
        return result;
    }
}
