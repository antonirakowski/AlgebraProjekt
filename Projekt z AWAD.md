*Antoni Rakowski, Adam Ryski, Michał Syrkiewicz, Jan Taran*
*Praca na podstawie książki:* http://neuralnetworksanddeeplearning.com/chap1.html

### Wstęp
W naszym projekcie, chcieliśmy zrozumieć sieci neuronowe, oraz przetestować tę wiedzę w praktyce i stworzyć sieć nie używając gotowych rozwiązań typu biblioteka **tensorflow**.
### Opowieść
Naszą przygodę zaczęliśmy od próby implementacji sieci z ksiąki przy użyciu języka Java. W tym celu stworzyliśmy własną bibliotekę do algebry liniowej. Niestety okazało się to karkołomnym zadaniem i była pełna błędów, których naprawianie nas przerosło. [1] *kod źródłowy w Java*. Karkołomność zadania była przede wszystkim spowodowana złożonością języka Java i oraz konwencje programowania SOLID. W związku z powyższymi okolicznościami zdecydowaliśmy się na implementację sieci w języku Dart, bardzo zbliżonym do Javy, aczkolwiek pozwalającym na prostszy kod. Ze względu na brak czasu zdecydowaliśmy się na użycie gotowej biblioteki do Algebry liniowej, ale sieć mimo tego zaprojektowaliśmy samodzielnie od zera. 

### Esencja działania naszej sieci
1. Budowa neuronu i jego implementacja w naszej sieci.
	Wykorzystaliśmy neurony typu sigmoidalnego, których możliwość rejestrowania wartości ciągłych znacznie zwiększa celność modelu.
	[[wzor]]
	Oczywiście nasza sieć wykorzystuje setki takich neuronów, ale zrozumienie działania pojedynczego neuronu jest wymagane do zrozumienia działania całej sieci.
1. Działanie sieci
2. 
3. Wynik naszej sieci

