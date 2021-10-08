import { Component, OnInit } from '@angular/core';
import {Resa} from "../../classes/resa";
import {ResaService} from "../../services/resa.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-resa-details',
  templateUrl: './resa-details.component.html',
  styleUrls: ['./resa-details.component.css']
})
export class ResaDetailsComponent implements OnInit {

  resa : Resa = new Resa();

  constructor(private rs : ResaService, private router : Router, private activateRoute : ActivatedRoute) { }

  ngOnInit(): void {
    let resaId = Number(this.activateRoute.snapshot.paramMap.get('id'));
    if (resaId > 0){
      this.rs.getResa(resaId).subscribe(
        data => {this.resa = data}
      )
    }
  }

}
