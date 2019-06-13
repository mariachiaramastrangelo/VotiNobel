#ricorsione ragionamento
Input:
- Set di esame
- Numero di crediti n

Output: set di esame sottoinsieme di quello di partenza per cui  la somma dei crediti è esattamente uguale a m e per cui la 
media dei voti degli esami è massima. 

La strategia è generare tutti i possibili sottoinsiemi dell'insieme di partenza
importante è non ripetere combinazioni uguale in ordine diverso 

#Approccio 1 genero l'insieme decidendo corso per corso se fa parte dell'insieme
in questo caso il livello della ricorsione dipende se includere o meno il corso in esame. La soluzione parziale è un sottoinsieme che può includere o meno corsi tra 0 e L-1

La generazione del sottoproblema è decidere se aggiungere L :
1. Sotto-problema: soluzione parziale;
2. sotto-problema è la soluzione parziale che ho ricevuto  + l-esimo corso;

Casi terminali: L= massimo cioè non ci sono più corsi;
	-somma crediti= m, calcolo la media 
	-somma crediti != m allora lascio perdere 
Generiamo ciecamente tutte le soluzioni. Se dopo 5 livelli di ricorsione ho crediti pari a m sforerei e non ha senso.
	
Nel caso terminale valuto m -->return
Somma crediti pari a m valuta la media e capisci e vedi se è la miglior media conosciuta
Complessità 2^N
#Approccio 2:
ad ogni livello aggiungo un corso devo decidere quale.
Per tutti i corsi possibili non ancora nel problema
	-sotto-problema= parziale +corso 
N è il numero degli esami;
Complessità N!
Posso evitare ripetizioni se posso scegliere solo quelli in posizione successiva scendendo in maniera crescente