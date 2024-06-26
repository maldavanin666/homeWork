package src.family_tree;

import src.family_tree.Iterator.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String file = "C:/Users/Кирилка/Desktop/Familytree/homeWork/src/src/family_tree/tree.txt";
        FamilyTree tree = tree();
        //FamilyTree tree = load(file);
        System.out.println(tree);

        save(tree, file);
    }

    private static FamilyTree load(String file){
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(file);
    }

    private static void save(FamilyTree tree, String file){
        Writable writable = new FileHandler();
        writable.save(tree, file);
    }

    private static FamilyTree tree() {
        FamilyTree tree = new FamilyTree();


        Human sergej = new Human("Сергей", Gender.Male, LocalDate.of(1993, 5, 5));
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1995, 1, 1));


        tree.add(maria);
        tree.add(sergej);

        Human misha = new Human("Миша", Gender.Male, LocalDate.of(2014, 12, 24));
        misha.addParent(maria);
        misha.addParent(sergej);
        tree.add(misha);

        Human ded = new Human("Дед Валера", Gender.Male,LocalDate.of(1950, 4, 19));
        ded.addChild(maria);
        tree.add(ded);


        return tree;
    }
}