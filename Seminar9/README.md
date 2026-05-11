# Seminar 9

## Pjesa teorike (OOD)

1. **Fazat e SDLC**:
   - Planifikimi dhe analiza e kërkesave
   - Dizajnimi i sistemit
   - Implementimi (kodimi)
   - Testimi
   - Vendosja në përdorim (deployment)
   - Mirëmbajtja

2. **Disa modele të zhvillimit të softuerit**:
   - Waterfall
   - Iterative
   - Incremental
   - Spiral
   - Agile (Scrum, Kanban)
   - V-Model

3. **Kartat CRC (Class–Responsibility–Collaboration)** shërbejnë për:
   - përcaktimin e përgjegjësive të klasave,
   - identifikimin e bashkëpunimeve mes klasave,
   - ndërtimin e modelit OOP para implementimit.

4. **Relacionet mes klasave (me shembuj)**:
   - Shoqërimi (Association): `Student` — `Kurs`
   - Agregimi (Aggregation): `Departament` ka `Punonjës`
   - Kompozimi (Composition): `Shtëpi` ka `Dhoma`
   - Trashëgimia (Inheritance): `Punonjës` trashëgon `Person`
   - Varësia (Dependency): `RaportService` përdor `Printer`

5. **Simbolet UML të relacioneve**:
   - Association: vijë e thjeshtë
   - Aggregation: vijë me romb bosh (te klasa “whole”)
   - Composition: vijë me romb të mbushur (te klasa “whole”)
   - Inheritance (Generalization): vijë me trekëndësh bosh drejt klasës bazë
   - Dependency: vijë e ndërprerë me shigjetë

6. **Shoqërimi (Association)** është lidhje strukturore ku objektet e një klase lidhen me objektet e një klase tjetër (p.sh. një student regjistrohet në disa kurse).

7. **Kompozim apo agregim në diagrama**:
   - Diagrami me **romb të mbushur** është **kompozim**.
   - Diagrami me **romb bosh** është **agregim**.
   - Arsyetim: në kompozim pjesa nuk ka jetë të pavarur nga “whole”, ndërsa në agregim po.

## Ushtrime të implementuara

- **Exercise1/**: Relacioni `Punonjes`–`Adresa` (agregim) + implementimi i klasave.
- **Exercise2/**: Hierarkia e trashëgimisë `A -> Punonjes -> B`.

