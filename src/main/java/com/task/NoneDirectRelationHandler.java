package com.task;

import java.util.ArrayList;


// This class contain all the method to get the target relatives
public class NoneDirectRelationHandler {
    public static ArrayList<Person> getCousin(Person target){
        // Assume father and mother has same children
        Person father = target.getFather();          
        ArrayList<Person> result = father.getChildren();
        result.remove(target);
        return result;
    } 

    public static ArrayList<Person> getBrother(Person target){
        Person father = target.getFather();          
        ArrayList<Person> result = father.getSon();
        result.remove(target);
        return result;
    }

    public static ArrayList<Person> getSister(Person target){
        Person father = target.getFather();           
        ArrayList<Person> result =  father.getDaughter();
        result.remove(target);
        return result;
    }

    public static ArrayList<Person> getPaternalUncle(Person target){
        Person father = target.getFather();        
        Person grandFather = father.getFather();   
        ArrayList<Person> result = grandFather.getSon();
        result.remove(father);
        return result;
    }

    public static ArrayList<Person> getMaternalUncle(Person target){
        Person mother = target.getMother();
        Person grandFather = mother.getFather();        
        return grandFather.getSon();
    }

    public static ArrayList<Person> getPaternalAunt(Person target){
        Person father = target.getFather();
        Person grandFather = father.getFather();        
        return grandFather.getDaughter();
    }

    public static ArrayList<Person> getMaternalAunt(Person target){
        Person mother = target.getMother();
        Person grandFather = mother.getFather();        
        ArrayList<Person> result = grandFather.getDaughter();
        result.remove(mother);
        return result;
    }

    public static ArrayList<Person> getSisterInLaw(Person target){
        Person spouse = target.getSpouse();
        Person spouseFather = spouse.getFather();        
        ArrayList<Person> result = spouseFather.getDaughter();
        result.remove(spouse);
        return result;
    }

    public static ArrayList<Person> getBrotherInLaw(Person target){
        Person spouse = target.getSpouse();
        Person spouseFather = spouse.getFather();        
        ArrayList<Person> result = spouseFather.getSon();
        result.remove(spouse);
        return result;
    }

    public static ArrayList<Person> getGrandDaughter(Person target){
        ArrayList<Person> result = new ArrayList<Person>();
        ArrayList<Person> children = target.getChildren();
        if(!children.isEmpty()){
            for(Person child : children){
                ArrayList<Person> grandDaughters = child.getDaughter();
                result.addAll(grandDaughters);
            }
        } else {
            throw new Error(target + "'s children don't have any daughter yet");
        }
        return result;
    }

    public static ArrayList<Person> getGrandSon(Person target){
        ArrayList<Person> result = new ArrayList<Person>();
        ArrayList<Person> children = target.getChildren();
        if(!children.isEmpty()){
            for(Person child : children){
                ArrayList<Person> grandDaughters = child.getSon();
                result.addAll(grandDaughters);
            }
        } else {
            throw new Error(target + "'s children don't have any son yet");
        }
        return result;
    }
}