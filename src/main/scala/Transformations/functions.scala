package Transformations

import Caseclass.{Actors, Names}

case object functions{
  def heightMoreThan(names: Names, h: Integer): Boolean ={
    if(names.height == null) return false
    return names.height > h
  }

  def specificJob(actors: Actors, job: String): Boolean={
    if(job == null) return false
    return actors.job == job
  }
}
