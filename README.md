# Projet : Injection de Dépendances en Java

## Description
Ce projet démontre l'implémentation de l'injection de dépendances en Java à travers différentes approches, mettant en avant les concepts de couplage faible et fort, l'inversion de contrôle et la modularité du code. L'objectif est de créer une application fermée aux modifications mais ouverte à l'extension, en suivant les principes SOLID.

## Diagramme de Classe
Le diagramme de classe ci-dessous représente la structure de l'application. Il montre comment les différentes classes interagissent et comment les dépendances sont gérées via des interfaces.

![Diagramme de classe](https://github.com/FatihaELHABTI/demo_ic/blob/main/demo_ioc/src/main/resources/imgs/diagramme.PNG)

## Concepts Clés

### 1. Couplage Fort vs Couplage Faible
- **Couplage Fort** : Une classe dépend directement d'une autre, ce qui rend le code rigide et difficile à modifier.
- **Couplage Faible** : Une classe ne connaît que l'interface d'une autre classe, facilitant ainsi l'évolutivité du code.

### 2. Inversion de Contrôle (IoC)
L'inversion de contrôle consiste à déléguer la création des dépendances à un composant externe plutôt qu'à l'intérieur des classes elles-mêmes.

### 3. Injection de Dépendances (DI)
L'injection de dépendances est une manière d'implémenter l'IoC en fournissant à une classe ses dépendances plutôt que de les instancier elle-même.

## Types d'Instanciation Utilisés

### 1. Instanciation Statique
Cette approche consiste à créer les objets directement dans le code avec `new`, ce qui induit un couplage fort.

```java
DaoImplV2 d = new DaoImplV2();
MetierImpl metier = new MetierImpl(d);
System.out.println("Res : " + metier.calcul());
```

### 2. Instanciation Dynamique
Une approche plus flexible consiste à utiliser la réflexion et un fichier de configuration pour charger dynamiquement les classes.

```java
Scanner sc = new Scanner(new File("config.txt"));
String daoClassname = sc.nextLine();
Class cDao = Class.forName(daoClassname);
IDao dao = (IDao) cDao.getConstructor().newInstance();
```

Cette approche permet de modifier les implémentations sans toucher au code source.

### 3. Injection avec Spring (XML et Annotations)
Avec Spring, on peut gérer l'injection des dépendances de manière déclarative via XML ou annotations.

#### a) Injection via XML

```xml
<bean id="d" class="ext.DaoImplV2"/>
<bean id="metier" class="metier.MetierImpl">
    <property name="dao" ref="d"/>
    <!-- Injection avec constructeur <constructor-arg ref="d"/> -->
</bean>
```

#### b) Injection via Annotations

```java
@Service("metier")
public class MetierImpl implements IMetier{
    private IDao dao;

    
    public MetierImpl(@Qualifier("dao") IDao dao) {
        this.dao = dao;
    }
}
```

L'utilisation d' `@Qualifier` permet à Spring d'injecter automatiquement les dépendances nécessaires.

### Exécution avec Spring

#### Via XML
```java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
IMetier metier = context.getBean(IMetier.class);
System.out.println("Res : " + metier.calcul());
```

#### Via Annotations
```java
ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier","ext");
IMetier metier = context.getBean(IMetier.class);
System.out.println("Res Ver Annotation : " + metier.calcul());
```


