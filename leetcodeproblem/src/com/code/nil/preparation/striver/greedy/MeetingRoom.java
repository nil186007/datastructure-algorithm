package com.code.nil.preparation.striver.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingRoom {

    static class Meeting 
            //implements Comparable 
    {

        int startTime;
        int endTime;
        int meetingId;

        public Meeting(int startTime, int endTime, int meetingId) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.meetingId = meetingId;
        }

       /* @Override
        public int compareTo(Object o) {
            if(this.endTime!= ((Meeting) o).endTime){
                return this.endTime-((Meeting) o).endTime;
            }else{
                return this.meetingId-((Meeting) o).meetingId;
            }
        }*/

        @Override
        public String toString() {
            return "Meeting{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", meetingId=" + meetingId +
                    '}';
        }
    }

    public static void main(String[] args) {

        int [] startTime = {1,2,3};
        int [] endTime = {4,4,4};
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<startTime.length;i++){
            meetings.add(new Meeting(startTime[i],endTime[i],i));
        }
        Collections.sort(meetings,(m1, m2)->{
            if(m1.endTime==m2.endTime){
                return m1.meetingId- m2.meetingId;
            }else{
                return m1.endTime-m2.endTime;
            }
        });

        List<Integer> meetingIds = new ArrayList<>();
        int currentMeetingEndTime=-1;
        //int totalMeetingCount;
        for(int i=0; i<meetings.size(); i++){

            if(meetings.get(i).startTime>currentMeetingEndTime){
                meetingIds.add(meetings.get(i).meetingId);
                currentMeetingEndTime = meetings.get(i).endTime;
            }

        }

        System.out.println(meetingIds);

    }

}
