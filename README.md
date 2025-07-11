# EssentialCore

EssentialCore erweitert die Grundfunktionen von [EssentialsX](https://essentialsx.net/) in einem kompakten Plugin. Das Projekt verwendet Maven und ist für Minecraft Versionen 1.21 bis 1.21.7 ausgelegt.

## Features

- `/heal` – regeneriert Gesundheit und Hunger
- `/feed` – füllt den Hungerbalken auf
- `/sethome` – speichert deinen aktuellen Standort
- `/home` – teleportiert dich zu deinem Zuhause
- `/setspawn` – legt den globalen Spawnpunkt fest
- `/spawn` – teleportiert zum Spawnpunkt
- `/afk` – schaltet deinen AFK-Status um
- `/fly` – erlaubt das Fliegen
- `/day` – stellt die Tageszeit auf Tag
- `/night` – stellt die Tageszeit auf Nacht
- `/gamemode` – wechselt deinen Spielmodus
- `/god` – schaltet Unverwundbarkeit um
- `/help` – zeigt eine Liste aller Befehle
- `/balance [Spieler]` (Alias: `bal`, `ebal`, `ebalance`, `money`, `emoney`) – zeigt dein oder das Guthaben eines anderen Spielers
- `/pay` – sende Geld an andere Spieler
- `/setmoney` – setze das Guthaben eines Spielers (Admin)

Neue Spieler starten mit 100 Coins. Alle Kontostände werden in `balances.yml`
gespeichert und bleiben somit nach Server-Neustarts erhalten.

Das Plugin nutzt eine klare Ordnerstruktur mit `commands` und `listeners`, sodass du es leicht erweitern kannst.

## Berechtigungen

| Befehl   | Permission            |
|----------|----------------------|
| `/heal`  | `essentialcore.heal` |
| `/feed`  | `essentialcore.feed` |
| `/sethome` | `essentialcore.sethome` |
| `/home`  | `essentialcore.home` |
| `/setspawn` | `essentialcore.setspawn` |
| `/spawn` | `essentialcore.spawn` |
| `/afk`   | `essentialcore.afk`  |
| `/fly`   | `essentialcore.fly`  |
| `/day`   | `essentialcore.day`  |
| `/night` | `essentialcore.night` |
| `/gamemode` | `essentialcore.gamemode` |
| `/god`   | `essentialcore.god`  |
| `/help` | `essentialcore.help` |
| `/balance` | `essentialcore.balance` |
| `/balance [Spieler]` | `essentialcore.balance.other` |
| `/pay`  | `essentialcore.pay` |
| `/setmoney` | `essentialcore.setmoney` |
