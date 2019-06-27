package com.mobileapps.week02day03zoo.DataBase;

import com.mobileapps.week02day03zoo.Models.Animal;

import java.util.ArrayList;

public class DummyAnimalsDataBaseHelper
{

    public ArrayList<Animal> getAllAnimal()
    {
        ArrayList<Animal> animals = new ArrayList<>();
        //Mammals
        animals.add(new Animal("Giant Anteater","Mammals","anteater","anteater","Geographical Range\tCentral and South America (southern Belize to northern Argentina)\n" +
                "Habitat\tSwamps, humid forests, savannahs\n" +
                "Scientific Name\tMyrmecophaga tridactyla\n" +
                "Conservation Status\tNear threatened\n" +
                "Watch Out for That Tongue!\n" +
                "What's the first thing you notice about a giant anteater? Probably its long snout. But the animal's tongue is even longer, extending up to two feet!\n" +
                "\n" +
                "A Giant among Anteaters\n" +
                "Giant anteaters are the largest of the four anteater species -- up to 50 inches long, plus another 25 to 35 inches for the fan-like tail. In color, they're mostly brown to gray brown, with a darker stripe (bordered by white) that extends from the throat to the middle of the back.\n" +
                "\n" +
                "Dinner Time\n" +
                "It's obvious that anteaters like to eat...well, ants! But they also eat termites and the eggs and cocoons of these insects. Sometimes they broaden the menu, snacking on beetle larvae and fruits.\n" +
                "\n" +
                "Giant anteaters sniff out their prey (since their eyesight is poor). They use their powerful front limbs and large claws to dig into termite and ant mounds. Then they use their long, sticky tongue to slurp up their food. Yum!"));

        animals.add(new Animal("Andean Bear","Mammals","bear","bear","Geographical Range\tWestern South America\n" +
                "Habitat\tMountain forests to coastal scrublands\n" +
                "Scientific Name\tTremarctos ornatus\n" +
                "Conservation Status\tThreatened\n" +
                "This clever bear often builds a platform of broken branches in a tree and stands on it to reach fruit. Not only does it feed in trees, but it builds nests in the branches for sleeping. Andean bears live in the high, humid forests of the Andes Mountains and in thorn forests along the South American coast. They eat fruit, cactus and other plants, and sometimes feed on small animals.\n" +
                "\n" +
                "Did You Know?\n" +
                "This bear has white circles around its eyes, which make it look like it's wearing spectacles."));

        animals.add(new Animal("Elephants","Mammals","elephant","elephant","Geographical Range\tIndia, Sri Lanka, Southeast Asia\n" +
                "Habitat\tScrub forests, adjoining grasslands, jungles where remaining\n" +
                "Scientific Name\tElephas maximus\n" +
                "Conservation Status\tEndangered\n" +
                "Elephants and Us\n" +
                "Asian elephants have long been important to humans. Whether it's their key role in the Hindu religion and culture, their longstanding use as beasts of burden, their slaughter for the ivory trade, or their current conflicts with the exploding human population -- elephants have always fascinated us.\n" +
                "\n" +
                "Elephants have been domesticated in Asia for centuries, bred to move people and cargo. In the past, wealthy Indians and royalty owned elephants, riding on their elaborately decorated backs on hunting trips into the bush. Because they are intelligent and docile (when well treated), they have been widely used in the lumber industry to haul heavy items such as teak logs."));



        //Birds
        animals.add(new Animal("Penguin","Birds","penguin","penguin","Penguins (order Sphenisciformes, family Spheniscidae) are a group of aquatic flightless birds. They live almost exclusively in the Southern Hemisphere, with only one species, the Galapagos penguin, found north of the equator. Highly adapted for life in the water, penguins have countershaded dark and white plumage, and their wings have evolved into flippers. Most penguins feed on krill, fish, squid and other forms of sea life which they catch while swimming underwater. They spend roughly half of their lives on land and the other half in the sea.\n" +
                "\n" +
                "Although almost all penguin species are native to the Southern Hemisphere, they are not found only in cold climates, such as Antarctica. In fact, only a few species of penguin live so far south. Several species are found in the temperate zone, and one species, the Galápagos penguin, lives near the equator.\n" +
                "\n" +
                "The largest living species is the emperor penguin (Aptenodytes forsteri):[1] on average, adults are about 1.1 m (3 ft 7 in) tall and weigh 35 kg (77 lb). The smallest penguin species is the little blue penguin (Eudyptula minor), also known as the fairy penguin, which stands around 40 cm (16 in) tall and weighs 1 kg (2.2 lb). Among extant penguins, larger penguins inhabit colder regions, while smaller penguins are generally found in temperate or even tropical climates (see also Bergmann's rule). Some prehistoric species attained enormous sizes, becoming as tall or as heavy as an adult human. These were not restricted to Antarctic regions; on the contrary, subantarctic regions harboured high diversity, and at least one giant penguin occurred in a region around 2,000 km south of the equator 35 mya, in a climate decidedly warmer than today"));

        return animals;
    }

    public ArrayList<Animal> filterBy(String category,ArrayList<Animal> animals)
    {
        ArrayList<Animal> aux = new ArrayList<>();

        for(Animal animal:animals)
        {
            if(animal.getCategory().equals(category))
            {
                aux.add(animal);
            }
        }

        return aux;
    }

}
