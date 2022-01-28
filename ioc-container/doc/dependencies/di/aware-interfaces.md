# Spring Aware Interfaces Beispiel

## ApplicationContextAware und BeanNameAware

Wenn ein ApplicationContext eine Objektinstanz erzeugt, die die Schnittstelle org.springframework.context.**ApplicationContextAware** implementiert, 
wird die Instanz mit einer Referenz auf diesen ApplicationContext versehen.
So können Beans den ApplicationContext, der sie erstellt hat, programmatisch manipulieren, 
und zwar über die ApplicationContext-Schnittstelle oder durch Casting der Referenz 
auf eine bekannte Unterklasse dieser Schnittstelle (z. B. ConfigurableApplicationContext, die zusätzliche Funktionen bereitstellt).


Im Allgemeinen sollte dies jedoch vermeiden, da es den Code an Spring koppelt 
und nicht dem Stil der Inversion of Control folgt, bei dem Kollaborateure Beans 
als Eigenschaften zur Verfügung gestellt werden.

Autowiring ist eine weitere Alternative, um einen Verweis auf den ApplicationContext zu erhalten. 
Die traditionellen Autowiring-Modi **constructor** und **byType** (wie in [Autowiring Collaborators](autowire.md) beschrieben) 
können eine Abhängigkeit vom Typ ApplicationContext für ein Konstruktorargument bzw. einen Setter-Methodenparameter bereitstellen. 
Für mehr Flexibilität, einschließlich der Möglichkeit, Felder und Methoden mit mehreren Parametern zu autowiren, 
verwenden Sie die annotationsbasierten Autowiring-Funktionen. 
In diesem Fall wird der ApplicationContext automatisch in ein Feld, 
ein Konstruktorargument oder einen Methodenparameter verdrahtet, der den ApplicationContext-Typ erwartet, 
wenn das betreffende Feld, der Konstruktor oder die Methode die @Autowired-Annotation enthält. 
Weitere Informationen finden Sie unter Verwenden von @Autowired.

Wenn ein ApplicationContext eine Klasse erstellt, die das
org.springframework.beans.factory.**BeanNameAware** Interface mplementiert, erhält die Klasse einen Verweis auf den Namen, 
der in ihrer zugehörigen Objektdefinition definiert ist. Das folgende Listing zeigt die Definition der BeanNameAware-Schnittstelle:
public interface BeanNameAware {
void setBeanName(String name) throws BeansException;
}
Der Callback wird nach der Population der normalen Bean-Eigenschaften, aber vor einem Initialisierungs-Callback
wie InitializingBean.afterPropertiesSet() oder einer benutzerdefinierten init-Methode aufgerufen.



### Andere Aware Interfaces
siehe Referenzen

## Referenzen
[Other Aware Interfaces](https://spring.getdocs.org/en-US/spring-framework-docs/docs/spring-core/beans/beans-factory-nature.html#aware-list)


## [zurück zu spring-ioc-container](../../../spring-ioc-container.md)
