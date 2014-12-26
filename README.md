tests
=====

Tests with several technologies

# Per fare girare tutto sotto Karaf

- Installo karaf pulito
- lancio
- faccio (per web console)
	- feature:install webconsole
- faccio (declarative services
	- feature:install scr
- cambio il log in org.ops4j.pax.logging.cfg
	- aggiungo stdout ai log printati
		- log4j.rootLogger=INFO, out, stdout, osgi:*
	- modifico l'appender stdout per avere la treshold a TRACE
		- log4j.appender.org.energy_home=TRACE
			
- butto i miei bundle in deploy


# note
- http://sully6768.blogspot.it/2012/09/scr-components-with-karaf.html


