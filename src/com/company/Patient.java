package com.company;

import java.util.LinkedList;

public class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public Patient(String name, String doc, String dep, String date, String time) {

        this.name = name;
        Hospital h = new Hospital(doc,dep,date,time);
        addData(h);
    }

    private LinkedList<Hospital> patientLL = new LinkedList<Hospital>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addData(Hospital hospital){
        patientLL.add(hospital);
    }

    public void deleteGivenNode(Hospital hospital){
        for(int i=0;i<patientLL.size();i++){
            if( patientLL.get(i).getDoctor().equalsIgnoreCase(hospital.getDoctor()) &&
                patientLL.get(i).getDepartment().equalsIgnoreCase(hospital.getDepartment())  &&
                patientLL.get(i).getDate().equalsIgnoreCase(hospital.getDate()) &&
                patientLL.get(i).getTime().equalsIgnoreCase(hospital.getTime()))

                    patientLL.remove(i);
      }

    }

    public Hospital getData(){
        if(patientLL.size()>0)
            return patientLL.remove();
        return null;
    }



    @Override
    public String toString() {
        String result="";
        for(int i=0;i<patientLL.size();i++)
            result+=name+","+patientLL.get(i)+"\n";

        return result;
    }
}
